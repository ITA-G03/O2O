package ita.o2o.service;

import ita.o2o.dto.OrderDto;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.Order;

import java.util.List;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
public interface OrderService {

    int createOrder(OrderDto orderDto);
    int updateOrder(Order order);

    List<Order> getAllByCustomerId(int userId);


    List<Order> getCurrentUserOrderList(Business business);
    List<Order> getAllNewOrderByBusiness(Business business);
    List<Order> getAllNewAcceptedOrderByBusiness(Business business);
    List<Order> getAllSendingOrderByBusiness(Business business);
    List<Order> getAllFinishedOrderByBusiness(Business business);

}
