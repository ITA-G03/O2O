package ita.o2o.jms;

import java.util.List;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import ita.o2o.entity.base.Order;
import ita.o2o.util.StoreMessage;
import ita.o2o.util.mapper.JSONMapper;

public class ReceiveMessage implements Runnable{
	
	private ConnectionFactory factory=null;
	private Queue queue=null;
	private Connection conn = null;
	private Session sen = null;
	private MessageConsumer consumer=null;
	private String queueName = "sequence";
	private JSONMapper mapper;
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		mapper = new JSONMapper();
		factory = new ActiveMQConnectionFactory("failover://tcp://localhost:61616");
		queue = new ActiveMQQueue(queueName);
		try {
			conn = factory.createConnection();
			sen = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			consumer = sen.createConsumer(queue);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.start();
			Message msg = consumer.receive();
			TextMessage tmsg = (TextMessage)msg;
			String str = tmsg.getText();
//System.out.println(str);
			Order order = mapper.readStringAsObject(str,Order.class);
			StoreMessage.order.add(order);
			System.out.println(order.getAcceptTime());
			System.out.println(StoreMessage.order.size());
			consumer.close();
			sen.close();
			conn.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
