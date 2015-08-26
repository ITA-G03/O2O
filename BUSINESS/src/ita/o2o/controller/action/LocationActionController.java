package ita.o2o.controller.action;

import ita.o2o.constants.O2OConstants;
import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.User;
import ita.o2o.entity.location.Area;
import ita.o2o.entity.location.City;
import ita.o2o.entity.location.Location;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/action/location", produces = "application/json; charset=utf-8")
public class LocationActionController extends BaseController {
    @Autowired
    JSONMapper jsonMapper;

    @RequestMapping("/search")
    @ResponseBody
    public String loginAction(@RequestParam Integer cityId, @RequestParam String areaName, HttpSession session) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(O2OConstants.SUCCESS);
        Location location = new Location();
        City city = new City();
        city.setCityId(cityId);

        //此处需要根据CityId获取CityName，以下是假数据方案
        switch (cityId) {
            case 1:
                city.setCityName("珠海");
                break;
            case 2:
                city.setCityName("广州");
                break;
            case 3:
                city.setCityName("深圳");
                break;
            default:
                break;
        }

        Area area = new Area();
        area.setAreaName(areaName);
        location.setArea(area);
        location.setCity(city);
        session.setAttribute("location", location);
        return jsonMapper.writeObjectAsString(responseMessage);
    }
}
