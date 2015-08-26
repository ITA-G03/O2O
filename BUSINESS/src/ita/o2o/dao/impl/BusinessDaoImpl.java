package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.base.Business;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by WhiteSaber on 15/8/26.
 */
@Repository("businessDao")
public class BusinessDaoImpl extends BaseDaoImpl<Business> {

    public BusinessDaoImpl() {
        super(Business.class);
    }

    @Override
    public List<Business> getAll() {
        CriteriaBuilder criteriaBuilder = this.getManager().getCriteriaBuilder();
        CriteriaQuery<Business> criteriaQuery = criteriaBuilder.createQuery(Business.class);
        Root<Business> root = criteriaQuery.from(Business.class);
        List<Business> resultList = this.getManager().createQuery(criteriaQuery).getResultList();
        return resultList;
    }

    @Override
    public int create(Business business) {
        try {
            this.getManager().persist(business);
            return business.getBusinessId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return O2OConstants.DEFAULT_FAILURE_CODE;
    }
}
