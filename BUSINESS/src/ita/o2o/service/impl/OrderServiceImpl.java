package ita.o2o.service.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.dao.impl.OderDaoImpl;
import ita.o2o.dao.impl.UserDaoImpl;
import ita.o2o.dto.FoodDto;
import ita.o2o.dto.OrderDto;
import ita.o2o.entity.base.*;
import ita.o2o.entity.extra.Status;
import ita.o2o.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
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
    OderDaoImpl orderDao;

    @Autowired
    UserDaoImpl userDao;

    @Override
    @Transactional
    public int createOrder(OrderDto orderDto) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
        return orderDao.create(order);
    }

    @Override
    public List<Order> getCurrentUserOrderList(Business business) {
        return orderDao.getByBusiness(business);
    }

    @Override
    public int updateOrder(Order order) {
        return 0;
    }

    @Override
    public List<Order> getAllByCustomerId(int userId) {
        User customer=userDao.getById(userId);
        return orderDao.getByCustomer(customer);
    }

    private List<OrderItem> orderItemConvert(List<FoodDto> foodDtos, Order order){
        List<OrderItem> orderItems = new ArrayList<>();
        for(Object object : foodDtos){
            LinkedHashMap map = (LinkedHashMap)object;
            Food food = new Food();
            food.setFoodId((int) map.get("id"));
            food.setFoodName((String) map.get("name"));
            double price = (double)map.get("price");
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
}
