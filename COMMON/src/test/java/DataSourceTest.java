import ita.o2o.entity.extra.FoodType;
import ita.o2o.entity.extra.Role;
import ita.o2o.entity.extra.Status;
import ita.o2o.entity.extra.WorkStatus;
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
        System.out.println("Init");
        factory = Persistence.createEntityManagerFactory("o2oPersistenceUnit");

    }

    @Before
    public void start() {
        manager = factory.createEntityManager();

    }


    /*
    * 根据Entity 建表测试
    *
    * */
    @Test
    public void testLocation ()throws Exception{
        System.out.println("Hi~~");
        City city=new City();
        city.setCityName("ZhuHai");
        Area area=new Area();
        area.setAreaName("TongGa");
        Location location=new Location();
        location.setArea(area);
        location.setCity(city);
        location.setDetail("South Software Park");

        manager.getTransaction().begin();
        manager.persist(location);
        manager.getTransaction().commit();
        System.out.println("Bye~~");
    }

    @Test
    public void testWorkStatus(){
        System.out.println("Test WorkStatus");
        WorkStatus workStatus=new WorkStatus();
        workStatus.setWorkStatusName("OffLine");

        manager.getTransaction().begin();
        manager.persist(workStatus);
        manager.getTransaction().commit();
        System.out.println("End");
    }

    @Test
    public void testRole(){
        System.out.println("Test Role");
        Role role=new Role();
        role.setRoleName("Admin");

        manager.getTransaction().begin();
        manager.persist(role);
        manager.getTransaction().commit();
        System.out.println("End");
    }

    @Test
    public void testStatus(){
        System.out.println("Test Status");
        Status status=new Status();
        status.setStatusName("Accept");

        manager.getTransaction().begin();
        manager.persist(status);
        manager.getTransaction().commit();
        System.out.println("End");
    }

    @Test
    public void testFoodType(){
        System.out.println("Test FoodType");
        FoodType foodType=new FoodType();
        foodType.setFoodTypeName("Drink");

        manager.getTransaction().begin();
        manager.persist(foodType);
        manager.getTransaction().commit();
        System.out.println("End");
    }



}
