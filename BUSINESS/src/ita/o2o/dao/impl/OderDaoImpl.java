package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.Order;
import ita.o2o.entity.base.User;
import ita.o2o.entity.extra.Status;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by ZHANGJA4 on 8/26/2015.
 */
@Repository("orderDao")
public class OderDaoImpl extends BaseDaoImpl<Order> {
    public static final String USER_ID="userId";
    public static final String CUSTOMER="customer";
    public static final String BUSINESS="business";
    public static final String STATUS="status";

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

    public List<Order> getByBusiness(Business business) {
        CriteriaBuilder criteriaBuilder = this.getManager().getCriteriaBuilder();
        CriteriaQuery<Order> criteriaBuilderQuery = criteriaBuilder.createQuery(Order.class);
        Root<Order> root = criteriaBuilderQuery.from(Order.class);


        System.out.println("Join表查询啦~~");
        root.fetch(BUSINESS, JoinType.LEFT);
        Predicate predicate=criteriaBuilder.conjunction();
        Predicate equalPredicate=criteriaBuilder.equal(root.<User>get(BUSINESS),business);
        predicate=criteriaBuilder.and(predicate,equalPredicate);
        criteriaBuilderQuery.select(root).where(predicate);

        List<Order> resultList = this.getManager().createQuery(criteriaBuilderQuery).getResultList();
        System.out.println("查出来数据了哟~Size:"+resultList.size());
        return resultList;
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

    public List<Order> getByCustomer(User customer) {
        CriteriaBuilder criteriaBuilder = this.getManager().getCriteriaBuilder();
        CriteriaQuery<Order> criteriaBuilderQuery = criteriaBuilder.createQuery(Order.class);
        Root<Order> root = criteriaBuilderQuery.from(Order.class);


        System.out.println("Join表查询啦~~");
        root.fetch(CUSTOMER, JoinType.LEFT);
        Predicate predicate=criteriaBuilder.conjunction();
        Predicate equalPredicate=criteriaBuilder.equal(root.<User>get(CUSTOMER),customer);
        predicate=criteriaBuilder.and(predicate,equalPredicate);
        criteriaBuilderQuery.select(root).where(predicate);

        List<Order> resultList = this.getManager().createQuery(criteriaBuilderQuery).getResultList();
        System.out.println("查出来数据了哟~Size:"+resultList.size());
        return resultList;
    }

    public List<Order> getAllByBusinessAndStatus(Business business, Status status) {
        CriteriaBuilder criteriaBuilder = this.getManager().getCriteriaBuilder();
        CriteriaQuery<Order> criteriaBuilderQuery = criteriaBuilder.createQuery(Order.class);
        Root<Order> root = criteriaBuilderQuery.from(Order.class);


        System.out.println("Join表查询啦~~");
        root.fetch(BUSINESS, JoinType.LEFT);
        Predicate predicate=criteriaBuilder.conjunction();
        Predicate equalPredicate=criteriaBuilder.equal(root.<Status>get(STATUS),status);
        predicate=criteriaBuilder.and(predicate,equalPredicate);
        criteriaBuilderQuery.select(root).where(predicate);
        List<Order> resultList = this.getManager().createQuery(criteriaBuilderQuery).getResultList();
        System.out.println("查出来数据了哟~Size:"+resultList.size());
        return resultList;
    }
}
