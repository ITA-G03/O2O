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

    public MessageConsumer getConsumer(){
        MessageConsumer consumer = (MessageConsumer)this.session.getAttribute("consumer");
        if(consumer != null){
            return consumer;
        }
        Connection con = null;
        Session sen = null;
        try {
            System.out.println("start consumer");
            ConnectionFactory factory = new ActiveMQConnectionFactory("failover://tcp://localhost:61616");
            Topic topic = new ActiveMQTopic("O2O_topic");
            con = factory.createConnection();
//            con.setClientID("o2o_customer_system");
            sen = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            consumer = sen.createConsumer(topic);
            con.start();
            this.session.setAttribute("consumer", consumer);
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
        return consumer;
    }

    public void getOrderMessage(){
            MessageConsumer consumer = this.getConsumer();
            List<Order> orders = (List<Order>)this.session.getAttribute("jmsOrderList");
            if(null == orders){
                orders = new ArrayList<>();
            }
            while(true){
                System.out.println("receive message");
                Message msg = null;
                try {
                    msg = consumer.receive(3000);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
                TextMessage tm = (TextMessage)msg;
                System.out.println("no text message ?");
                if(tm == null){
                    break;
                }
                try {
                    if(null == jsonMapper){
                        System.out.println("empty json mapper");
                    }
                    jsonMapper = new JSONMapper();
                    System.out.println(tm.getText());
                    Order order = jsonMapper.getObjectMapper().readValue(tm.getText(),Order.class);
                    orders.add(order);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(orders.size() > 0){
                this.session.setAttribute("jmsOrderList",orders);
            }
        }
}
