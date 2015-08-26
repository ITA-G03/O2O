package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.extra.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-26
 */
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role>{


    public RoleDaoImpl() {
        super(Role.class);
    }



    @Override
    public List<Role> getAll() {
        CriteriaBuilder criteriaBuilder=this.getManager().getCriteriaBuilder();
        CriteriaQuery<Role> criteriaQuery=criteriaBuilder.createQuery(Role.class);
        Root<Role> root=criteriaQuery.from(Role.class);
        return this.getManager().createQuery(criteriaQuery).getResultList();
    }

    @Override
    public int create(Role role) {
        try{
            this.getManager().persist(role);
            return role.getRoleId();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return O2OConstants.DEFAULT_FAILURE_CODE;
    }
}
