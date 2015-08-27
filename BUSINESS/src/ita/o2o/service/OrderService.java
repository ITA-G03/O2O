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

    public int createOrder(OrderDto orderDto);

    public List<Order> getCurrentUserOrderList(Business business);

    public int updateOrder(Order order);

    List<Order> getAllByCustomerId(int userId);
}
