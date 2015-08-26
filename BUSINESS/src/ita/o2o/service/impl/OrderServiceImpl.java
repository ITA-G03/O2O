package ita.o2o.service.impl;

import ita.o2o.dao.impl.OderDaoImpl;
import ita.o2o.entity.base.Order;
import ita.o2o.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by ZHANGJA4 on 8/26/2015.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OderDaoImpl orderDao;

    @Override
    @Transactional
    public int createOrser(Order order) {
        int createFlag = orderDao.create(order);
        System.out.println("Service Create Flag:" + createFlag);
        System.out.println("Id:" + order.getOrderId());
        return createFlag;
    }

}
