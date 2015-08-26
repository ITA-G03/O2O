package ita.o2o.controller.restful;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.base.Food;
import ita.o2o.entity.base.Order;
import ita.o2o.entity.base.OrderItem;
import ita.o2o.entity.extra.Status;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @ResponseBody
    @RequestMapping(value = "/new-order")
    public String getNewOrderList() {
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


}
