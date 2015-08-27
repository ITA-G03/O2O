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

    @PersistenceContext
    private EntityManager manager;

    public BaseDaoImpl() {
    }

    public BaseDaoImpl(Class<T> rootType) {
        System.out.println("Setting rootType:"+rootType.getName());
        this.rootType = rootType;
    }

    @Override
    public <T> T getById(Class<T> c, int id) {
        return manager.find(c, id);
    }

    @Override
    public T getById(int id) {
        return manager.find(rootType,id);
    }

    @Override
    public <T> T getByName(String name) {
        return null;
    }


    @Override
    public <T> boolean update(T t) {
        try {
            manager.merge(t);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public <T> boolean delete(T t) {
        try {
            manager.remove(t);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }





    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }
}
