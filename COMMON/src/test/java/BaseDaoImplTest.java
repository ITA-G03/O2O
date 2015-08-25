import ita.o2o.dao.impl.AreaDaoImpl;
import ita.o2o.entity.location.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jason Cui
 * @version 2015-08-25
 */
public class BaseDaoImplTest {


    @Autowired
    AreaDaoImpl areaDao;


    @Test
    public void areaDaoTest(){
        System.out.println("Start Area Testing!");
        Area area=new Area();
        area.setAreaName("Hong Kong");
        areaDao.create(area);

        System.out.println("End");
    }

}
