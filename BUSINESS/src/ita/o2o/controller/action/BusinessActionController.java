package ita.o2o.controller.action;

import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.User;
import ita.o2o.entity.location.Area;
import ita.o2o.entity.location.City;
import ita.o2o.entity.location.Location;
import ita.o2o.service.impl.BusinessServiceImpl;
import ita.o2o.service.impl.LocationServiceImpl;
import ita.o2o.service.impl.UserServiceImpl;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/business", produces = "application/json;charset=utf-8")
@SessionAttributes("user")
public class BusinessActionController {
    @Autowired
    JSONMapper jsonMapper;

    @Autowired
    BusinessServiceImpl businessService;

    @Autowired
    LocationServiceImpl locationService;

    @Autowired
    UserServiceImpl userService;

    @ResponseBody
    @RequestMapping(value = "/register-business")
    public String registBusiness(@ModelAttribute("user") User user, String signboard, Integer idCardId, Integer licenseId, String comments, String city, String area, String detail) {
        System.out.println("signboard: " + signboard);
        System.out.println("comments: " + comments);
        System.out.println("idCardId: " + idCardId);
        System.out.println("licenseId: " + licenseId);
        //location
        System.out.println("city: " + city);
        System.out.println("area: " + area);
        System.out.println("detail: " + detail);

        Business business = businessService.getById(1);
        business.setRealName(signboard);
        business.setLicenseId(licenseId);
        business.setIdCardId(idCardId);
        business.setIntroduction(comments);

        //set Location
        Location location = new Location();
        //City
        City city1 = new City();
        city1.setCityId(1);
        //Area
        Area area1 = new Area();
        area1.setAreaId(1);
        location.setArea(area1);
        location.setCity(city1);
        //Detail
        location.setDetail(comments);
        business.setLocation(location);
        businessService.updateBusiness(business);
        return "";
    }

    @ResponseBody
    @RequestMapping(value = "/setting/profile")
    public String updateBusinessInfo(@ModelAttribute("user") User user, String signboard, Integer idCardId, Integer licenseId, String comments, String city, String area, String detail) {
        System.out.println("signboard: " + signboard);
        System.out.println("comments: " + comments);
        System.out.println("idCardId: " + idCardId);
        System.out.println("licenseId: " + licenseId);
        //location
        System.out.println("city: " + city);
        System.out.println("area: " + area);
        System.out.println("detail: " + detail);

        User currentUser = userService.getById(user.getUserId());
        Business business = businessService.getByUser(currentUser);


        if (null != signboard && !signboard.isEmpty())
            business.setRealName(signboard);
        if (null != licenseId && licenseId > 0)
            business.setLicenseId(licenseId);
        if (null != idCardId && idCardId > 0)
            business.setIdCardId(idCardId);
        if (null != comments && !comments.isEmpty())
            business.setIntroduction(comments);

        Location location = business.getLocation();
        //city

        //eara

        //detail
        business.setIntroduction(comments);
        businessService.updateBusiness(business);
//        ResponseMessage responseMessage = new
        return "";
    }

}
