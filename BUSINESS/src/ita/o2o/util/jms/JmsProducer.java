package ita.o2o.util.jms;

import ita.o2o.entity.base.Order;
import ita.o2o.util.mapper.JSONMapper;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.*;

/**
 * Created by YUKE on 8/27/2015.
 */
public class JmsProducer {

    @Autowired
    JSONMapper jsonMapper;

    public void sendOrderMessage(Order order){
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory("failover://tcp://localhost:61616");
            Topic topic = new ActiveMQTopic("O2O_topic");
            Connection con = factory.createConnection();
//            con.setClientID("o2o_customer_system");
            Session sen = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            Destination destination = sen.createTopic("O2O_oder_topic");
//            MessageProducer producer = sen.createProducer(destination);
//            producer.setDeliveryMode(DeliveryMode.PERSISTENT);//??????
            MessageProducer producer = sen.createProducer(topic);
            con.start();
//            Gson gson = new Gson();
            //gson.toJson(order)
            jsonMapper = new JSONMapper();
            TextMessage tm = sen.createTextMessage(jsonMapper.writeObjectAsString(order));
            producer.send(tm);
            sen.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        JmsProducer jp = new JmsProducer();
        Order order = new Order();
        order.setOrderId(111);
        jp.sendOrderMessage(order);
    }
}
