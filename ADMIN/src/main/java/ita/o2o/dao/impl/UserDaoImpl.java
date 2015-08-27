package ita.o2o.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ita.o2o.dao.UserDao;
import ita.o2o.entity.base.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager em;

	public List<User> query() {
		String ql = "select User(u.userId,u.tel) from User u";
		Query q = em.createQuery(ql);
		List<User> list = q.getResultList();
		return list;
	}

	public int getIdByTel(String tel) {
		CriteriaBuilder buidler = em.getCriteriaBuilder();
		CriteriaQuery<User> query = buidler.createQuery(User.class);
		Root<User> root = query.from(User.class);
		User u = em.createQuery(
				query.where(buidler
						.equal(root.get("tel").as(String.class), tel)))
				.getSingleResult();
		return u.getUserId();
	}

	public boolean update(int id) {
		User u = em.find(User.class, id);
		u.setEncryptedPassword("123456");
		try {
			em.merge(u);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;

	}

}
