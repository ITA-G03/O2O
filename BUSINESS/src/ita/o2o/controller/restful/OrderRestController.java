package ita.o2o.controller.restful;

import ita.o2o.constants.O2OConstants;
import ita.o2o.dto.BusinessDto;
import ita.o2o.dto.FoodDto;
import ita.o2o.entity.base.*;
import ita.o2o.entity.extra.Status;
import ita.o2o.service.BusinessService;
import ita.o2o.service.impl.BusinessServiceImpl;
import ita.o2o.service.impl.OrderServiceImpl;
//import ita.o2o.service.impl.RoleServiceImpl;
import ita.o2o.service.impl.RoleServiceImpl;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZHANGJA4 on 8/25/2015.
 */
@Controller
//@RequestMapping(produces = "application/json;charest=utf-8")
@RequestMapping(value = "/order", produces = "application/json;charset=utf-8")
public class OrderRestController {
    @Autowired
    JSONMapper jsonMapper;

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    BusinessServiceImpl businessService;


    public void GenTestData() {
        Order o1 = new Order();
//        o1.setOrderId(1);
        o1.setComments("给钱上楼");
//        o1.setAcceptTime("");
//        status
//        Status status = new Status();
//        status.setStatusId(1);
//        status.setStatusName("waiting");
//        o1.setStatus(status);
//        o1.setComments("只吃妹子做的");
//        //Business
//        Business business = new Business();
//        business.setRealName("赵日天");
//        //Location
//        Location location = new Location();
//        location.setDetail("武松岗");
//        //city
//        City city = new City();
//        city.setCityName("青岛没啤酒");
//        location.setCity(city);
//        //Area
//        Area area = new Area();
//        area.setAreaName("桂林有米粉");
//        location.setArea(area);
//        business.setLocation(location);
        //user
        User user = new User();
//        user.setLocation(location);
        user.setNickName("天天");
        user.setTel("820488");
        user.setRole(roleService.getById(O2OConstants.ROLE_BUSINESS));
        System.out.println(user.getRole().getRoleId());
        System.out.println(user.getRole().getRoleName());
//        business.setOwner(user);
        orderService.createOrder(o1);
        System.out.println("create finish..");
    }

    @ResponseBody
    @RequestMapping(value = "/testOrderList")
    public String testOrderList() {
        Business business = businessService.getById(22);
        List<Order> orderList = orderService.getCurrentUserOrderList(business);
        return jsonMapper.writeObjectAsDataString(orderList);
    }

    @ResponseBody
    @RequestMapping(value = "/new-order")
    public String getNewOrderList() {
        //test!!!!!!!!!!!!!!!!!!!!!!!!
//        GenTestData();


        List<Order> orderList = new LinkedList<>();
        Order o1 = new Order();
        o1.setOrderId(1);
        o1.setComments("给钱上楼");
        o1.setAcceptTime("");
        Status status = new Status();
        status.setStatusId(1);
        status.setStatusName("waiting");
        o1.setStatus(status);
        Order o2 = new Order();
        o2.setOrderId(2);
        o2.setStatus(status);
        o2.setComments("只吃妹子做的");


        List<OrderItem> orderItemList = new LinkedList<>();
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setCount(2);
        Food food1 = new Food();
        food1.setFoodName("麻辣豆腐花");
        orderItem1.setFood(food1);
        OrderItem orderItem2 = new OrderItem();
        Food food2 = new Food();
        food2.setFoodName("芝麻炒西瓜");
        orderItem2.setCount(1);
        orderItem2.setFood(food2);
        orderItemList.add(orderItem1);
        orderItemList.add(orderItem2);
        o1.setOrderItemList(orderItemList);
        o2.setOrderItemList(orderItemList);

        orderList.add(o1);
        orderList.add(o2);

        return jsonMapper.writeObjectAsDataString(orderList);
    }


    @ResponseBody
    @RequestMapping(value = "/history-order")
    public String getHistoryOrderList() {
        List<Order> orderList = new LinkedList<>();
        Order o1 = new Order();
        o1.setOrderId(1);
        o1.setComments("给钱上楼");
        o1.setAcceptTime("");
        Status status = new Status();
        status.setStatusId(1);
        status.setStatusName("waiting");
        o1.setStatus(status);
        Order o2 = new Order();
        o2.setOrderId(2);
        o2.setStatus(status);
        o2.setComments("只吃妹子做的");


        List<OrderItem> orderItemList = new LinkedList<>();
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setCount(2);
        Food food1 = new Food();
        food1.setFoodName("麻辣豆腐花");
        orderItem1.setFood(food1);
        OrderItem orderItem2 = new OrderItem();
        Food food2 = new Food();
        food2.setFoodName("芝麻炒西瓜");
        orderItem2.setCount(1);
        orderItem2.setFood(food2);
        orderItemList.add(orderItem1);
        orderItemList.add(orderItem2);
        o1.setOrderItemList(orderItemList);
        o2.setOrderItemList(orderItemList);

        orderList.add(o1);
        orderList.add(o2);

        return jsonMapper.writeObjectAsDataString(orderList);
    }

    @ResponseBody
    @RequestMapping(value = "/accept")
    public String accept(String orderId) {
        System.out.println(orderId);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(O2OConstants.SUCCESS);
        return jsonMapper.writeObjectAsString(responseMessage);
    }

    @ResponseBody
    @RequestMapping(value = "/reject")
    public String reject(String orderId) {
        System.out.println(orderId);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(O2OConstants.SUCCESS);
        return jsonMapper.writeObjectAsString(responseMessage);
    }

    @ResponseBody
    @RequestMapping(value = "/cart/session", method = RequestMethod.POST)
    public void setShoppingCartSession(ArrayList<FoodDto> foods, HttpSession session) {
        System.out.println(foods.size());
        session.setAttribute("currentCart", foods);
    }

    @ResponseBody
    @RequestMapping(value = "/cart/session", method = RequestMethod.GET)
    public String getShoppingCartSession(HttpSession session) {
        List<FoodDto> foods = (List<FoodDto>)session.getAttribute("currentCart");
        int businessId = (int)session.getAttribute("currentRestaurant");
        BusinessDto businessDto = new BusinessDto();
        businessDto.setId(businessId);
        businessDto.setFoodList(foods);
        //add business name in session
        return jsonMapper.writeObjectAsString(businessDto);
    }


}
