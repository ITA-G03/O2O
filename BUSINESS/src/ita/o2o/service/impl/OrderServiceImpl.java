package ita.o2o.service.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.dao.impl.OderDaoImpl;
import ita.o2o.dao.impl.StatusDaoImpl;
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

    @Autowired
    StatusDaoImpl statusDao;

    @Override
    @Transactional
    public int createOrder(Order order) {
        int createFlag = orderDao.create(order);
        System.out.println("Service Create Flag:" + createFlag);
        System.out.println("Id:" + order.getOrderId());
        return createFlag;
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
