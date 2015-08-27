package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.dao.BusinessDao;
import ita.o2o.entity.base.Business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository("businessDao")
public class BusinessDaoImpl{
	
	 @PersistenceContext
	    private EntityManager manager;


	public List<Business> getAllApprovingBusiness(){
		String ql="from Business where status=:status";
		Query q=manager.createQuery(ql);
		q.setParameter("status", O2OConstants.STATUS_APPROVING);
		List<Business> list=q.getResultList();	
		return list;
	}

}
