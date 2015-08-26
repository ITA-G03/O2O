package ita.o2o.controller.action;

import ita.o2o.controller.BaseController;
import ita.o2o.entity.location.Area;
import ita.o2o.service.impl.AreaServiceImpl;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-25
 */
@Controller
@RequestMapping("/area")
public class AreaActionController extends BaseController{
    @Autowired
    AreaServiceImpl areaService;

    @Autowired
    JSONMapper jsonMapper;

    /*下面的功能全部是缩写,不要学*/

    @RequestMapping("/create")
    public void createAreaAction(){

        Area area=new Area();
        area.setAreaName("Bye Bye");

        areaService.createArea(area);
        System.out.println("End");

    }


    @RequestMapping("/view/{areaId}")
    @ResponseBody
    public String getAreaInfo(@PathVariable("areaId") String areaId){
        Area area=areaService.getById(Integer.valueOf(areaId));
        return jsonMapper.writeObjectAsString(area);
    }


    @RequestMapping("view/all")
    @ResponseBody
    public String getAllAreaInfo(){
        List<Area> areaList=areaService.getAll();
        return jsonMapper.writeObjectAsString(areaList);
    }
}
