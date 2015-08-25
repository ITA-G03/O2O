package ita.o2o.controller.restful;


import ita.o2o.entity.base.Business;
import ita.o2o.entity.extra.Status;
import ita.o2o.entity.location.Area;
import ita.o2o.entity.location.City;
import ita.o2o.entity.location.Location;
import ita.o2o.util.bean.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BusinessRestController {

    /**
     * 改变对应商家的信息
     *
     * @param business
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/business/change")
    public void changeBusinessInfo(@RequestParam("signboard") String name
                                   ) {
//        System.out.println(business);
        return;
    }


    /**
     * 获得当前商家的信息
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/business/setting/profile")
    public Business getCurrentBusinessInfo() {
//        System.out.printf(businessId.toString());
//        System.out.printf(businessId.toString());
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
        location.setDetail("xx路XX街道办");
        business.setLocation(location);
        //status
        Status status = new Status();
        status.setStatusId(1);
        status.setStatusName("申请");
        //comments
//        business.set`
        business.setStatus(status);
        return business;
    }

    /**
     * 获得对应商家的信息
     *
     * @param businessId
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/business/{businessId}")
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



/*
    *//**
     * 审核商家的申请
     *
     * @param businessId,statusId
     * @return Business
     *//*
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/business/audit/{businessId}")
    public Business auditBusinessApply(@PathVariable Integer businessId, @RequestParam(value = "status") Integer statusId) {
        Business business = new Business();
        business.setBusinessId(businessId);
        business.setRealName("奥尔良煎饼");
        Status status1 = new Status();
        status1.setStatusId(statusId);
        business.setStatus(status1);
        return null;
    }*/


}
