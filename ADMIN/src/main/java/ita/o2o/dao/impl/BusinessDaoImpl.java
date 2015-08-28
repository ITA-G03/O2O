package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.dao.BusinessDao;
import ita.o2o.entity.base.Business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository("businessDao")
public class BusinessDaoImpl implements BusinessDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Business> getAllApprovingBusiness() {
		CriteriaBuilder buidler = manager.getCriteriaBuilder();
		CriteriaQuery<Business> query = buidler.createQuery(Business.class);
		Root<Business> root = query.from(Business.class);

		List<Business> result = manager.createQuery(
				query.where(buidler.equal(root.get("status").get("statusId")
						.as(Integer.class), O2OConstants.STATUS_APPROVING)))
				.getResultList();
		return result;

	}

	@Override
	public boolean update(Business business) {
		this.manager.merge(business);
		return true;
	}

	@Override
	public Business get(int id) {
		return this.manager.find(Business.class, id);
	}
	
	
	@Override
	public List<Business> getAllAcceptedgBusiness() {				
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Business> query = builder.createQuery(Business.class);
		Root<Business> root = query.from(Business.class);

		List<Business> result = manager.createQuery(
				query.where(builder.equal(root.get("status").get("statusId")
						.as(Integer.class), O2OConstants.STATUS_ACCEPTED)))
				.getResultList();
		return result;
	}

	@Override
	public List<Business> getAllHotBusiness() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Business> query = builder.createQuery(Business.class);
		Root<Business> root = query.from(Business.class);

		List<Business> result = manager.createQuery(
				query.where(builder.equal(root.get("status").get("statusId")
						.as(Integer.class), O2OConstants.STATUS_HOT)))
				.getResultList();
		return result;
		
	}

	@Override
	public List<Business> getAllRejectedBusiness() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Business> query = builder.createQuery(Business.class);
		Root<Business> root = query.from(Business.class);

		List<Business> result = manager.createQuery(
				query.where(builder.equal(root.get("status").get("statusId")
						.as(Integer.class), O2OConstants.STATUS_REJECTED)))
				.getResultList();
		return result;
	}

	@Override
	public List<Business> getAllBusiness() {
		String ql = "from Business";
		Query q = manager.createQuery(ql);
		List<Business> all = q.getResultList();
		return all;
	}
	

}
