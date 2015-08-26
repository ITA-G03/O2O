package ita.o2o.controller.restful;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.base.Order;
import ita.o2o.entity.base.OrderItem;
import ita.o2o.entity.extra.Status;
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
        o1.setComments("送上楼");
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
        orderItem1.setCount(100);
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setCount(200);
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
        o1.setComments("送上楼也不给钱");
        o1.setAcceptTime("");
        Status status = new Status();
        status.setStatusId(1);
        status.setStatusName("waiting");
        o1.setStatus(status);
        Order o2 = new Order();
        o2.setOrderId(2);
        o2.setStatus(status);
        o2.setComments("妹子做的有毒");


        List<OrderItem> orderItemList = new LinkedList<>();
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setCount(120);
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setCount(220);
        orderItemList.add(orderItem1);
        orderItemList.add(orderItem2);
        o1.setOrderItemList(orderItemList);
        o2.setOrderItemList(orderItemList);

        orderList.add(o1);
        orderList.add(o2);
        return jsonMapper.writeObjectAsDataString(orderList);
    }


}