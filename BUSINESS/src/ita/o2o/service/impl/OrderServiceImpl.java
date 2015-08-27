package ita.o2o.service.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.dao.impl.OrderDaoImpl;
import ita.o2o.dao.impl.StatusDaoImpl;
import ita.o2o.dao.impl.UserDaoImpl;
import ita.o2o.dto.FoodDto;
import ita.o2o.dto.OrderDto;
import ita.o2o.entity.base.*;
import ita.o2o.entity.extra.Status;
import ita.o2o.service.OrderService;
import ita.o2o.util.jms.JmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by ZHANGJA4 on 8/26/2015.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDaoImpl orderDao;

    @Autowired
    UserDaoImpl userDao;

    @Autowired
    StatusDaoImpl statusDao;

    @Override
    @Transactional
    public int createOrder(OrderDto orderDto) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Order order = new Order();
        order.setAcceptTime(sdf.format(new Date()));

        Business business = new Business();
        business.setBusinessId(orderDto.getBusinessDto().getId());
        order.setBusiness(business);

        order.setCustomer(orderDto.getUser());
        order.setOrderItemList(orderItemConvert(orderDto.getFoodDtos(), order));
        Status status = new Status();
        status.setStatusId(O2OConstants.BUSINESS_STATUS_PENDING);
        order.setStatus(status);
        int result = orderDao.create(order);
        if(result > 0){
            JmsProducer jmsProducer = new JmsProducer();
            jmsProducer.sendOrderMessage(order);
        }
        return result;
    }

    @Override
    public int updateOrder(Order order) {
        return 0;
    }

    @Override
    public List<Order> getAllByCustomerId(int userId) {
        User customer=userDao.getById(userId);
        List<Order> orderList=orderDao.getByCustomer(customer);
        for(Order order:orderList){
            for(OrderItem orderItem:order.getOrderItemList()){
                orderItem.setOrder(null);
            }
        }
        return orderList;
    }

    private List<OrderItem> orderItemConvert(List<FoodDto> foodDtos, Order order){
        List<OrderItem> orderItems = new ArrayList<>();
        for(Object object : foodDtos){
            LinkedHashMap map = (LinkedHashMap)object;
            Food food = new Food();
            food.setFoodId((int) map.get("id"));
            food.setFoodName((String) map.get("name"));
            double price = Double.valueOf(map.get("price").toString());
            int num = (int)map.get("num");
            OrderItem orderItem = new OrderItem();
            orderItem.setFood(food);
            orderItem.setCount(num);
            orderItem.setPriceSnapshot(price);
            orderItem.setOrder(order);
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    /*商家查询订单系列:根据订单状态查询*/
    @Override
    public List<Order> getCurrentUserOrderList(Business business) {
        return orderDao.getByBusiness(business);
    }

    @Override
    public List<Order> getAllNewOrderByBusiness(Business business){
        return orderDao.getAllByBusinessAndStatus(business,statusDao.getById(O2OConstants.STATUS_NEW_ORDER));
    }

    @Override
    public List<Order> getAllNewAcceptedOrderByBusiness(Business business){
        return orderDao.getAllByBusinessAndStatus(business,statusDao.getById(O2OConstants.STATUS_BUSINESS_ACCEPTED));
    }

    @Override
    public List<Order> getAllSendingOrderByBusiness(Business business){
        return orderDao.getAllByBusinessAndStatus(business,statusDao.getById(O2OConstants.STATUS_FOOD_SENT_OUT));
    }

    @Override
    public List<Order> getAllFinishedOrderByBusiness(Business business){
        return orderDao.getAllByBusinessAndStatus(business,statusDao.getById(O2OConstants.STATUS_FINISHED));
    }
}
