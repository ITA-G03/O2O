package ita.o2o.controller.action;

import ita.o2o.constants.O2OConstants;
import ita.o2o.dao.impl.WorkStatusDaoImpl;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.User;
import ita.o2o.entity.extra.Status;
import ita.o2o.entity.extra.WorkStatus;
import ita.o2o.entity.location.Area;
import ita.o2o.entity.location.City;
import ita.o2o.entity.location.Location;
import ita.o2o.service.impl.BusinessServiceImpl;
import ita.o2o.service.impl.LocationServiceImpl;
import ita.o2o.service.impl.StatusServiceImpl;
import ita.o2o.service.impl.UserServiceImpl;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;


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

    @Autowired
    StatusServiceImpl statusService;

    @Autowired
    WorkStatusDaoImpl workStatusDao;

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

        User user1 = userService.getById(user.getUserId());
        Business business = new Business();
        business.setOwner(user1);
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

        //店铺status
        Status status = statusService.getById(O2OConstants.STATUS_APPROVING);
        System.out.println("status:" + status.getStatusName());
        //workStaus
        WorkStatus workStatus = workStatusDao.getById(O2OConstants.WORK_STATUS_CLOSE);
        System.out.println("workStatus:" + workStatus.getWorkStatusName());
        business.setStatus(status);
        business.setWorkStatus(workStatus);

        if (businessService.createBusiness(business) >= 0) {
            //set response
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setStatus(O2OConstants.SUCCESS);
            return jsonMapper.writeObjectAsString(responseMessage);
        } else {
            //set response
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setStatus(O2OConstants.FAILURE);
            Map<String, String> body = new LinkedHashMap<>();
            body.put("message", "insert fail");
            responseMessage.setBody(body);
            return jsonMapper.writeObjectAsString(responseMessage);
        }
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

        //set response
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(O2OConstants.SUCCESS);
        return jsonMapper.writeObjectAsString(responseMessage);
    }

}
