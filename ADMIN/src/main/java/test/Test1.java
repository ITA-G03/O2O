package test;

import java.util.List;

import ita.o2o.entity.base.User;
import ita.o2o.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	private static EntityManagerFactory factory;
	private static EntityManager mm;
	private static ApplicationContext context;
	
	@BeforeClass
	public static void init(){
		//factory=Persistence.createEntityManagerFactory("testUnit");
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Before
	public void before(){
		//mm=factory.createEntityManager();
	}
	@AfterClass
	public static void destory(){
		//factory.close();
	}
	@Test
	public void testUser(){
//		String ql="select new User(u.userId,u.tel) from User u";
//		Query q=mm.createQuery(ql);
//		List<User> list=q.getResultList();		
//		System.out.println(list.size());
//		
//		System.out.println(list.get(0).getUserId());
		UserService us=(UserService)context.getBean("userService");
		us.query();
		
		
	}
	
	
}
