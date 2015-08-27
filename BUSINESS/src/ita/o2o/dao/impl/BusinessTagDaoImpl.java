package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.BusinessTag;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-27
 */
@Repository("businessTagDao")
public class BusinessTagDaoImpl extends  BaseDaoImpl<BusinessTag>{

    public static final String BUSINESS="business";


    public BusinessTagDaoImpl() {
        super(BusinessTag.class);
    }

    @Override
    public List<BusinessTag> getAll() {
        CriteriaBuilder criteriaBuilder=this.getManager().getCriteriaBuilder();
        CriteriaQuery<BusinessTag> criteriaQuery=criteriaBuilder.createQuery(BusinessTag.class);
        Root<BusinessTag> root=criteriaQuery.from(BusinessTag.class);
        List<BusinessTag> resultList=this.getManager().createQuery(criteriaQuery).getResultList();
        return resultList;
    }

    @Override
    public int create(BusinessTag businessTag) {
        try{
            this.getManager().persist(businessTag);
            return businessTag.getBusinessTagId();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return O2OConstants.DEFAULT_FAILURE_CODE;
    }


    public List<BusinessTag> getByBusiness(Business business){
        CriteriaBuilder criteriaBuilder = this.getManager().getCriteriaBuilder();
        CriteriaQuery<BusinessTag> criteriaQuery = criteriaBuilder.createQuery(BusinessTag.class);
        Root<BusinessTag> root = criteriaQuery.from(BusinessTag.class);
        Predicate predicate = criteriaBuilder.conjunction();
        Predicate equalPredicate = criteriaBuilder.equal(root.<Business>get(BUSINESS), business);
        predicate = criteriaBuilder.and(predicate, equalPredicate);
        criteriaQuery.select(root).where(predicate);
        return this.getManager().createQuery(criteriaQuery).getResultList();
    }
}
