package ita.o2o.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import ita.o2o.entity.base.Order;
import ita.o2o.util.mapper.JSONMapper;

public class Produces {
	
	public void sendMessage(Order order) {
		ConnectionFactory factory = new ActiveMQConnectionFactory("failover://tcp://localhost:61616");
		Queue queue = new ActiveMQQueue("sequence");
		Connection conn = null;
		Session sen = null;
		MessageProducer producer = null;
		TextMessage msg = null;
		JSONMapper mapper = new JSONMapper();
		
		Destination des = null;
		try {
		     conn = factory.createConnection();
			 sen = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			  producer = sen.createProducer(queue);
			 conn.start();
			 String str = mapper.writeObjectAsString(order);
System.out.println(str);
			 msg = sen.createTextMessage(str);
			 producer.send(msg);		 
			 producer.close();
			 sen.close();
			 conn.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
