package ita.o2o.controller.restful;

import ita.o2o.controller.BaseController;
import ita.o2o.entity.location.Area;
import ita.o2o.entity.location.City;
import ita.o2o.entity.location.Location;
import ita.o2o.service.impl.AreaServiceImpl;
import ita.o2o.service.impl.CityServiceImpl;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/rest/location", produces = "application/json; charset=utf-8")
public class LocationRestController extends BaseController {

    @Autowired
    JSONMapper jsonMapper;

    @Autowired
    AreaServiceImpl areaService;

    @Autowired
    CityServiceImpl cityService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public String getCurrent(HttpSession session) {
        Location location = (Location) session.getAttribute("location");
        return jsonMapper.writeObjectAsString(location);
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    @ResponseBody
    public String getCities() {
        List<City> cityList=cityService.getAll();
        return jsonMapper.writeObjectAsString(cityList);
    }

    @RequestMapping(value = "/area",method = RequestMethod.GET)
    @ResponseBody
    public String getAreas(){
        List<Area> areaList=areaService.getAll();
        return jsonMapper.writeObjectAsString(areaList);
    }
}
