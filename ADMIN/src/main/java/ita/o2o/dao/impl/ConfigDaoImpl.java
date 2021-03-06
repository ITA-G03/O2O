package ita.o2o.dao.impl;

import ita.o2o.entity.admin.Configuration;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import ita.o2o.dao.ConfigDao;

import org.springframework.stereotype.Repository;

@Repository("configDao")
public class ConfigDaoImpl implements ConfigDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Configuration> getAll() {
		String ql = "from Configuration";
		Query q = em.createQuery(ql);
		Object o = q.getSingleResult();
		List<Configuration> all = (List<Configuration>) o;
		return all;
	}

	@Override
	public Configuration getIdByName(String name) {

		CriteriaBuilder buidler = em.getCriteriaBuilder();
		CriteriaQuery<Configuration> query = buidler
				.createQuery(Configuration.class);
		Root<Configuration> root = query.from(Configuration.class);

		Configuration config = em.createQuery(
				query.where(buidler.equal(root.get("name").as(String.class),name))).getSingleResult();
		return config;

	}

	@Override
	public boolean update(Configuration config) {
		em.merge(config);
		return true;
	}

	@Override
	public void create(Configuration config) {

	}

	@Override
	public boolean delete(Configuration config) {
		return false;

	}

}
