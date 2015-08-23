package ita.o2o.controller.restful;


import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.Order;
import ita.o2o.entity.base.OrderItem;
import ita.o2o.entity.extra.Status;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by WhiteSaber on 15/8/23.
 */
@RestController
public class OrderController {

    /**
     * 获取指定用户的OrderList , for admin
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/Order/{userId}")
    public List<Order> getUserOrderListByUserId(@PathVariable String userId) {
        System.out.println(userId);

        List<Order> orderLinkedList = new LinkedList<Order>();
        {
            Order o1 = new Order();
            o1.setOrderId(1);
            o1.setStatus(new Status());
            o1.setAccept_time(Calendar.getInstance().getTime());
            o1.setBusiness(new Business());
            o1.setComments("");
            OrderItem orderItem = new OrderItem();

            orderItem.setCount(5);

            List<OrderItem> orderItemSet = new LinkedList<OrderItem>();
            orderItemSet.add(orderItem);
            o1.setOrderItemList(orderItemSet);
            orderLinkedList.add(o1);
        }
        return orderLinkedList;
    }


    /**
     * 获取当前用户｜商家拥有的OrderList
     *
     * @return List<OrderList>
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/Order/list")
    public List<Order> getCurrentUserOrderList() {
        return getUserOrderListByUserId("1");
    }

    /**
     * 用户提交订单，for customer
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/Order/create")
    public String addOrder(@RequestBody Order Order) {

        return "success";
    }

    /**
     * 用户/商家取消订单
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/Order/cancel/{OrderItemId}")
    public String cancelOrder(@PathVariable Integer OrderItemId) {
        System.out.println(OrderItemId);
        return "success";
    }

    /**
     * 商家接受订单
     *
     * @param OrderItemId
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/Order/accept/{OrderItemId}")
    public String acceptOrder(@PathVariable Integer OrderItemId) {
        System.out.println(OrderItemId);
        return "success";
    }



}