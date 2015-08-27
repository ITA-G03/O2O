package ita.o2o.controller.restful;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ContentType;
import ita.o2o.constants.O2OConstants;
import ita.o2o.dto.BusinessDto;
import ita.o2o.dto.FoodDto;
import ita.o2o.dto.OrderDto;
import ita.o2o.entity.base.*;
import ita.o2o.entity.extra.Status;
import ita.o2o.service.*;
import ita.o2o.service.impl.BusinessServiceImpl;
import ita.o2o.service.impl.OrderServiceImpl;
//import ita.o2o.service.impl.RoleServiceImpl;
import ita.o2o.service.impl.RoleServiceImpl;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import static org.springframework.core.GenericCollectionTypeResolver.getCollectionType;

/**
 * Created by ZHANGJA4 on 8/25/2015.
 */
@Controller
//@RequestMapping(produces = "application/json;charest=utf-8")
@RequestMapping(value = "/order", produces = "application/json;charset=utf-8")
@SessionAttributes("user")
public class OrderRestController {
    @Autowired
    JSONMapper jsonMapper;

    @Autowired
    OrderService orderService;

    @Autowired
    RoleService roleService;

    @Autowired
    BusinessService businessService;

    @Autowired
    UserService userService;

    @Autowired
    StatusService statusService;

    /**
     * 根据当前商家找到新订单
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/new-order")
    public String getNewOrderList(@ModelAttribute("user") User user) {

        User user1 = userService.getById(user.getUserId());
        Business business = businessService.getByUser(user1);
        List<Order> orderList1 = orderService.getAllNewOrderByBusiness(business);
        for (Order order : orderList1) {
            List<OrderItem> orderItemList = order.getOrderItemList();
            for (OrderItem orderItem : orderItemList) {
                Food food = orderItem.getFood();
                food.setOwner(null);
                orderItem.setOrder(null);
            }

            order.setBusiness(null);
        }
        return jsonMapper.writeObjectAsDataString(orderList1);
    }

    /**
     * 根据当前商家找到历史订单
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/history-order")
    public String getHistoryOrderList(@ModelAttribute("user") User user) {
        User user1 = userService.getById(user.getUserId());
        Business business = businessService.getByUser(user1);
        List<Order> orderList1 = orderService.getAllFinishedOrderByBusiness(business);
        for (Order order : orderList1) {
            List<OrderItem> orderItemList = order.getOrderItemList();
            for (OrderItem orderItem : orderItemList) {
                Food food = orderItem.getFood();
                food.setOwner(null);
                orderItem.setOrder(null);
            }

            order.setBusiness(null);
        }
        return jsonMapper.writeObjectAsDataString(orderList1);

    }


    /**
     * 根据当前商家找到已经接收的订单
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/accepted-order")
    public String getAcceptedOrderList(@ModelAttribute("user") User user) {
        User user1 = userService.getById(user.getUserId());
        Business business = businessService.getByUser(user1);
        List<Order> orderList1 = orderService.getAllNewAcceptedOrderByBusiness(business);
        for (Order order : orderList1) {
            List<OrderItem> orderItemList = order.getOrderItemList();
            for (OrderItem orderItem : orderItemList) {
                Food food = orderItem.getFood();
                food.setOwner(null);
                orderItem.setOrder(null);
            }

            order.setBusiness(null);
        }
        return jsonMapper.writeObjectAsDataString(orderList1);

    }


    /**
     * 根据当前商家找到正在配送订单
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sending-order")
    public String getSendingOrderList(@ModelAttribute("user") User user) {
        User user1 = userService.getById(user.getUserId());
        Business business = businessService.getByUser(user1);
        List<Order> orderList1 = orderService.getAllSendingOrderByBusiness(business);
        for (Order order : orderList1) {
            List<OrderItem> orderItemList = order.getOrderItemList();
            for (OrderItem orderItem : orderItemList) {
                Food food = orderItem.getFood();
                food.setOwner(null);
                orderItem.setOrder(null);
            }

            order.setBusiness(null);
        }
        return jsonMapper.writeObjectAsDataString(orderList1);

    }


    /**
     * accept order
     *
     * @param orderId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/accept")
    public String accept(Integer orderId) {
        System.out.println("/accept orderId:" + orderId);
        Order order = orderService.getOrderById(orderId);
        Status status = statusService.getById(O2OConstants.STATUS_BUSINESS_ACCEPTED);
        order.setStatus(status);
        ResponseMessage responseMessage = new ResponseMessage();
        if (orderService.updateOrder(order)) {
            responseMessage.setStatus(O2OConstants.SUCCESS);
        } else {
            responseMessage.setStatus(O2OConstants.FAILURE);
        }
        return jsonMapper.writeObjectAsString(responseMessage);
    }


    /**
     * finsh order
     *
     * @param orderId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/finsh")
    public String finish(Integer orderId) {
        System.out.println("/finsh orderId:" + orderId);
        Order order = orderService.getOrderById(orderId);
        Status status = statusService.getById(O2OConstants.STATUS_FINISHED);
        order.setStatus(status);
        ResponseMessage responseMessage = new ResponseMessage();
        if (orderService.updateOrder(order)) {
            responseMessage.setStatus(O2OConstants.SUCCESS);
        } else {
            responseMessage.setStatus(O2OConstants.FAILURE);
        }
        return jsonMapper.writeObjectAsString(responseMessage);
    }

    /**
     * reject order
     *
     * @param orderId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/reject")
    public String reject(Integer orderId) {
        System.out.println("/reject orderId:" + orderId);

        Order order = orderService.getOrderById(orderId);
        Status status = statusService.getById(O2OConstants.STATUS_REJECTED);
        ResponseMessage responseMessage = new ResponseMessage();

        if (orderService.updateOrder(order)) {
            responseMessage.setStatus(O2OConstants.SUCCESS);
        } else {
            responseMessage.setStatus(O2OConstants.FAILURE);
        }

        return jsonMapper.writeObjectAsString(responseMessage);
    }

    @ResponseBody
    @RequestMapping(value = "/cart/session", method = RequestMethod.POST, consumes = "application/json")
    public String setShoppingCartSession(@RequestBody String foods, HttpSession session) {
        BusinessDto businessDto = (BusinessDto) session.getAttribute("currentRestaurant");
        ObjectMapper objectMapper = jsonMapper.getObjectMapper();
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            List<FoodDto> foodList = objectMapper.readValue(foods, objectMapper.getTypeFactory().constructType(ArrayList.class, FoodDto.class));
            Map<Integer, List<FoodDto>> sessionMap = new HashMap<>();
            sessionMap.put(businessDto.getId(), foodList);
            session.setAttribute("currentCart", sessionMap);
            responseMessage.setStatus(O2OConstants.SUCCESS);
        } catch (IOException e) {
            responseMessage.setStatus(O2OConstants.FAILURE);
        }
        return jsonMapper.writeObjectAsString(responseMessage);
    }

    @ResponseBody
    @RequestMapping(value = "/cart/session", method = RequestMethod.GET)
    public String getShoppingCartSession(HttpSession session) {
        Map<Integer, List<FoodDto>> sessionMap = (Map<Integer, List<FoodDto>>) session.getAttribute("currentCart");
        BusinessDto businessDto = (BusinessDto) session.getAttribute("currentRestaurant");
        if (sessionMap != null) {
            businessDto.setFoodList(sessionMap.get(businessDto.getId()));
            return jsonMapper.writeObjectAsString(businessDto);
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
    public String createNewOrder(@RequestBody String order, HttpSession session) {
        ObjectMapper objectMapper = jsonMapper.getObjectMapper();
        OrderDto orderDto = null;
        try {
            orderDto = (OrderDto) objectMapper.readValue(order, OrderDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<Integer, List<FoodDto>> sessionMap = (Map<Integer, List<FoodDto>>) session.getAttribute("currentCart");
        BusinessDto businessDto = (BusinessDto) session.getAttribute("currentRestaurant");
        User user = (User) session.getAttribute("user");
        orderDto.setBusinessDto(businessDto);
        orderDto.setFoodDtos(sessionMap.get(businessDto.getId()));
        orderDto.setUser(user);
        int result = orderService.createOrder(orderDto);
        ResponseMessage responseMessage = new ResponseMessage();
        if (result > 0) {
            responseMessage.setStatus(O2OConstants.SUCCESS);
            session.setAttribute("currentCart", null);
        } else {
            responseMessage.setStatus(O2OConstants.FAILURE);
        }
        return jsonMapper.writeObjectAsString(responseMessage);
    }
}
