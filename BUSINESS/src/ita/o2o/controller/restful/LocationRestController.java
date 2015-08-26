package ita.o2o.controller.restful;

import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.User;
import ita.o2o.entity.location.City;
import ita.o2o.entity.location.Location;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = "/rest/location", produces = "application/json; charset=utf-8")
public class LocationRestController extends BaseController {

    @Autowired
    JSONMapper jsonMapper;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public String getCurrent(HttpSession session) {
        Location location = (Location) session.getAttribute("location");
        return jsonMapper.writeObjectAsString(location);
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    @ResponseBody
    public String getCities() {
        List<City> cities = new LinkedList<>();
        City city = new City("珠海");
        city.setCityId(1);
        City city1 = new City("广州");
        city1.setCityId(2);
        City city2 = new City("深圳");
        city2.setCityId(3);
        cities.add(city);
        cities.add(city1);
        cities.add(city2);
        return jsonMapper.writeObjectAsString(cities);
    }
}
