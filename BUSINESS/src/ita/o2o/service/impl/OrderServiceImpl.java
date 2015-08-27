package ita.o2o.service.impl;

import ita.o2o.dao.impl.OderDaoImpl;
import ita.o2o.dao.impl.UserDaoImpl;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.Order;
import ita.o2o.entity.base.User;
import ita.o2o.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public int createOrder(Order order) {
        int createFlag = orderDao.create(order);
        System.out.println("Service Create Flag:" + createFlag);
        System.out.println("Id:" + order.getOrderId());
        return createFlag;
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

}
