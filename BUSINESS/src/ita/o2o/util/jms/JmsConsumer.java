package ita.o2o.util.jms;

import ita.o2o.entity.base.Order;
import ita.o2o.util.mapper.JSONMapper;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by YUKE on 8/27/2015.
 */
public class JmsConsumer{

    private HttpSession session;

    @Autowired
    JSONMapper jsonMapper;

    public JmsConsumer(HttpSession session){
        this.session = session;
    }

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
                Message msg = consumer.receive(3000);
                TextMessage tm = (TextMessage)msg;
                if(tm == null){
                    break;
                }
                try {
                    Order order = jsonMapper.readValue(tm.toString(),Order.class);
                    orders.add(order);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(orders.size() > 0){
                this.session.setAttribute("jmsOrderList",orders);
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
