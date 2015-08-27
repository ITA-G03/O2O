package ita.o2o.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ita.o2o.dao.AdminDao;
import ita.o2o.entity.admin.Admin;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
	@PersistenceContext
	private EntityManager em;

	public boolean query(Admin a) {
		boolean flag = false;
		String ql = "from Admin where name=:name and encryptedPassword=:encryptedPassword";
		Query q = em.createQuery(ql);
		q.setParameter("name", a.getName());
		q.setParameter("encryptedPassword", a.getEncryptedPassword());
		List o = q.getResultList();
		if (o.size() != 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

}
