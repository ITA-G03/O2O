package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.extra.Status;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-27
 */
@Repository("statusDao")
public class StatusDaoImpl extends BaseDaoImpl<Status>{


    public StatusDaoImpl() {
        super(Status.class);
    }

    @Override
    public List<Status> getAll() {
        CriteriaBuilder criteriaBuilder=this.getManager().getCriteriaBuilder();
        CriteriaQuery<Status> criteriaQuery=criteriaBuilder.createQuery(Status.class);
        Root<Status> root=criteriaQuery.from(Status.class);
        return this.getManager().createQuery(criteriaQuery).getResultList();
    }

    @Override
    public int create(Status status) {
        try{
            this.getManager().persist(status);
            return status.getStatusId();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return O2OConstants.DEFAULT_FAILURE_CODE;
    }
}
