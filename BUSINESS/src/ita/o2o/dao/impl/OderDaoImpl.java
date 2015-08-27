package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZHANGJA4 on 8/26/2015.
 */
@Repository("orderDao")
public class OderDaoImpl extends BaseDaoImpl<Order> {

    public OderDaoImpl() {
        super(Order.class);
    }

    @Override
    public List<Order> getAll() {
        CriteriaBuilder criteriaBuilder = this.getManager().getCriteriaBuilder();
        CriteriaQuery<Order> criteriaBuilderQuery = criteriaBuilder.createQuery(Order.class);
        Root<Order> root = criteriaBuilderQuery.from(Order.class);
        List<Order> resultList = this.getManager().createQuery(criteriaBuilderQuery).getResultList();
        return resultList;
    }

    public List<Order> getById(Business business) {
        return null;
    }

    @Override
    public int create(Order order) {
        try {
            this.getManager().persist(order);
            return order.getOrderId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return O2OConstants.DEFAULT_FAILURE_CODE;
    }
}
