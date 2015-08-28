package ita.o2o.controller.restful;


import ita.o2o.constants.O2OConstants;
import ita.o2o.dto.BusinessDto;
import ita.o2o.dto.OrderDto;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.BusinessTag;
import ita.o2o.entity.base.Order;
import ita.o2o.entity.base.User;
import ita.o2o.entity.extra.Status;
import ita.o2o.entity.location.Area;
import ita.o2o.entity.location.City;
import ita.o2o.entity.location.Location;
import ita.o2o.service.UserService;
import ita.o2o.service.impl.BusinessServiceImpl;
import ita.o2o.service.impl.BusinessTagServiceImpl;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.jms.JmsConsumer;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/business", produces = "application/json;charset=utf-8")
@SessionAttributes("user")
public class BusinessRestController {
    @Autowired
    JSONMapper jsonMapper;

    @Autowired
    BusinessServiceImpl businessService;

    @Autowired
    BusinessTagServiceImpl businessTagService;

    @Autowired
    UserService userService;

    /**
     * 获得当前商家的信息
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/setting/profile")
    public String getCurrentBusinessInfo(@ModelAttribute("user") User currentUser) {
        User user1 = userService.getById(currentUser.getUserId());
        Business business = businessService.getByUser(user1);
        return jsonMapper.writeObjectAsString(business);
    }

    /*
    * 根据session中的location获取商家
    * */
    @RequestMapping("/list")
    @ResponseBody
    public String getAllBusinessByLocation(HttpServletRequest request) {
        Location currentLocation = (Location) (request.getSession().getAttribute("location"));
        List<Business> businessList;
        if (currentLocation == null) {
            businessList = businessService.getAll();
        } else {
            businessList = businessService.getAllByLocation(currentLocation);
        }
        return jsonMapper.writeObjectAsString(businessList);
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
    public String getBusinessInfoById(@PathVariable Integer businessId) {
        Business business = businessService.getById(businessId);
        return jsonMapper.writeObjectAsString(business);
    }


    @RequestMapping("/tag/{tagId}")
    @ResponseBody
    public String getBusinessListByTag(@PathVariable("tagId") String tagId) {

        BusinessTag tag = businessTagService.getById(Integer.valueOf(tagId));
        List<Business> businessList = businessService.getAll();
        List<Business> newBusinessList = new ArrayList<>();
        for (Business business : businessList) {
            boolean flag = false;
            for (BusinessTag businessTag : business.getBusinessTags()) {
                System.out.println("===Comparing: Tag" + tagId + "And business~Tag:" + businessTag.getBusinessTagId());
                if (businessTag.getBusinessTagId() == Integer.valueOf(tagId)) {
                    flag = true;
                }
            }
            if (flag) newBusinessList.add(business);
        }
        return jsonMapper.writeObjectAsString(newBusinessList);
    }

    @RequestMapping("/unread")
    @ResponseBody
    public String getJmsMessage(HttpSession session) {
        System.out.println("unread");
        new JmsConsumer(session).getOrderMessage();
        User user = (User)session.getAttribute("user");
        List<Order> orders = (List<Order>) session.getAttribute("jmsOrderList");
        if(orders != null){
            System.out.println(orders.size());
            List<OrderDto> orderDtos = businessService.getJmsMessageByBusinessId(user.getUserId(), orders);
            System.out.println(orderDtos.size());
            return jsonMapper.writeObjectAsString(orderDtos);
        } else {
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setStatus(O2OConstants.FAILURE);
            return jsonMapper.writeObjectAsString(responseMessage);
        }
    }

}
