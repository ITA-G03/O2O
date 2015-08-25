package ita.o2o.controller.action;

import ita.o2o.controller.BaseController;
import ita.o2o.entity.location.Area;
import ita.o2o.service.impl.AreaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jason Cui
 * @version 2015-08-25
 */
@Controller
@RequestMapping("/area")
public class AreaActionController extends BaseController{
    @Autowired
    AreaServiceImpl areaServiceImpl;

    @RequestMapping("/create")
    public void createAreaAction(){
        Area area=new Area();
        area.setAreaName("Bye Bye");

        areaServiceImpl.createArea(area);
        System.out.println("End");

    }
}
