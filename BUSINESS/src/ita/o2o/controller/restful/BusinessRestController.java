package ita.o2o.controller.restful;


import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.User;
import ita.o2o.entity.extra.Status;
import ita.o2o.entity.location.Area;
import ita.o2o.entity.location.City;
import ita.o2o.entity.location.Location;

import ita.o2o.service.BusinessService;
import ita.o2o.service.impl.BusinessServiceImpl;
import ita.o2o.util.mapper.JSONMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedList;
import java.util.List;


@Controller
@RequestMapping(value = "/business", produces = "application/json;charset=utf-8")
@SessionAttributes("user")
public class BusinessRestController {
    @Autowired
    JSONMapper jsonMapper;

    @Autowired
    BusinessServiceImpl businessService;

    /**
     * 获得当前商家的信息
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/setting/profile")
    public String getCurrentBusinessInfo(@ModelAttribute("user") User user) {
        //test data
      /*  Business business = new Business();
        business.setBusinessId(1);
        business.setRealName("奥尔良煎饼");
        business.setLogoId(123);
        //location
        Location location = new Location();
        Area area = new Area();
        area.setAreaId(1);
        area.setAreaName("广东");
        location.setArea(area);
        City city = new City();
        city.setCityId(556);
        city.setCityName("珠海");
        location.setCity(city);
        location.setDetail("xx路XX街道办");
        business.setLocation(location);
        //status
        Status status = new Status();
        status.setStatusId(1);
        status.setStatusName("申请");
        //comments
//        business.set`
        business.setStatus(status);*/


        Business business = businessService.getByUser(user);

        return jsonMapper.writeObjectAsString(business);
    }

    /**
     * test
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String getALlBusiness() {
        List<Business> businessList = new LinkedList<Business>();
        Business b1 = new Business();
        b1.setBusinessId(0);
        b1.setRealName("掌机");
        Business b2 = new Business();
        b2.setBusinessId(1);
        b2.setRealName("啦啦");
        businessList.add(b1);
        businessList.add(b2);
        return jsonMapper.writeObjectAsDataString(businessList);
    }

    /**
     * 获得对应商家的信息
     * test
     *
     * @param businessId
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/{businessId}")
    public Business getBusinessInfo(@PathVariable Integer businessId) {
        System.out.printf(businessId.toString());
        Business business = new Business();
        business.setBusinessId(1);
        business.setRealName("奥尔良煎饼");
        business.setLogoId(123);
        //location
        Location location = new Location();
        Area area = new Area();
        area.setAreaId(1);
        area.setAreaName("广东");
        location.setArea(area);
        City city = new City();
        city.setCityId(556);
        city.setCityName("珠海");
        location.setCity(city);
        business.setLocation(location);
        //status
        Status status = new Status();
        status.setStatusId(1);
        status.setStatusName("申请");
        business.setStatus(status);
        return business;
    }

}
