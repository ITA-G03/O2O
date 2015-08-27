package ita.o2o.util.jms;

import ita.o2o.entity.base.Order;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by YUKE on 8/27/2015.
 */
public class JmsConsumer{

    public List<Order> getOrderMessage(){
        Connection con = null;
        Session sen = null;
        MessageConsumer consumer = null;
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory("failover://tcp://localhost:61616");
            Topic topic = new ActiveMQTopic("O2O_topic");
            con = factory.createConnection();
            sen = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            consumer = sen.createConsumer(topic);
            con.start();
            List<Order> orders = new ArrayList<>();
            while(true){
                Message msg = consumer.receive(1000);
                TextMessage tm = (TextMessage)msg;
                if(tm == null){
                    break;
                }
//                orders.add();
            }
        } catch (JMSException e) {
            try {
                consumer.close();
                sen.close();
                con.close();
            } catch (JMSException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }
}
