import ita.o2o.entity.location.Area;
import ita.o2o.entity.location.City;
import ita.o2o.entity.location.Location;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
public class DataSourceTest {

    private static EntityManagerFactory factory;
    private EntityManager manager;

    @BeforeClass
    public static void init() {
        factory = Persistence.createEntityManagerFactory("o2oPersistenceUnit");

    }

    @Before
    public void start() {
        manager = factory.createEntityManager();

    }



    @Test
    public void testFactory ()throws Exception{
        System.out.println("Hi~~");
        City city=new City();
        city.setCityName("ZhuHai");
        Area area=new Area();
        area.setAreaName("TongGa");
        Location location=new Location()


        manager.getTransaction().begin();
        manager.persist(city);
        manager.getTransaction().commit();
        System.out.println("Bye~~");
    }
/*
    @Test
    public void testPersist() throws Exception {

        User u = new User();
        u.setUname("john");
        u.setSex(true);
        u.getTels().add("abc");
        Addr addr1 = new Addr();
        Addr addr2 = new Addr();
        addr1.setCity("bj");
        addr2.setCity("zh");
        addr1.setU(u);
        addr2.setU(u);

        manager.getTransaction().begin();
        manager.persist(addr1);

        manager.getTransaction().commit();
        System.out.println(u.getId());
    }

    @Test
    public void testFind() throws Exception {

        //User u=manager.find(User.class, primaryKey)
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //LocalContainerEntityManagerFactoryBean bean=(LocalContainerEntityManagerFactoryBean)context.getBean("entityManagerFactory");
        User u = new User();
        u.setSex(true);
        u.setUname("john");

//		UserDao ud=(UserDao)context.getBean("userDaoImpl");
//		ud.addUser(u);
        UserManager um = (UserManager) context.getBean("um");
        um.regist(u);
    }
    */
}
