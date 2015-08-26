package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.base.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-26
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User>{

    public static final String TEL="tel";

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public List<User> getAll() {
        CriteriaBuilder criteriaBuilder=this.getManager().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery=criteriaBuilder.createQuery(User.class);
        Root<User> root=criteriaQuery.from(User.class);
        return this.getManager().createQuery(criteriaQuery).getResultList();
    }

    @Override
    public int create(User user) {
        try{
            this.getManager().persist(user);
            return user.getUserId();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return O2OConstants.DEFAULT_FAILURE_CODE;
    }

    public User findByTel(String tel) {
        CriteriaBuilder criteriaBuilder=this.getManager().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery=criteriaBuilder.createQuery(User.class);
        Root<User> root=criteriaQuery.from(User.class);
        Predicate predicate=criteriaBuilder.conjunction();
        Predicate equalPredicate=criteriaBuilder.equal(root.<String>get(TEL), tel);
        predicate=criteriaBuilder.and(predicate,equalPredicate);
        criteriaQuery.select(root).where(predicate);
        return this.getManager().createQuery(criteriaQuery).getResultList().get(0);
    }
}
