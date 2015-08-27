package ita.o2o.dao.impl;

import ita.o2o.dao.BaseDao;
import ita.o2o.util.EntityUtils;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Jason Cui
 * @version 2015-08-25
 */
@Repository("baseDao")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {


	private Class<T> rootType = (Class<T>) EntityUtils.getEntityClass(this.getClass());

    

    public BaseDaoImpl() {
    }

    public BaseDaoImpl(Class<T> rootType) {
        System.out.println("Setting rootType:"+rootType.getName());
        this.rootType = rootType;
    }




}
