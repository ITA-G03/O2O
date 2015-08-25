package ita.o2o.dao.impl;

import ita.o2o.dao.BaseDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Jason Cui
 * @version 2015-08-25
 */
@Repository
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    @PersistenceContext
    EntityManager manager;


    @Override
    public <T> T getById(Class<T> c, int id) {
        return manager.find(c,id);
    }

    @Override
    public <T> T getByName(String name) {
        return null;
    }


    @Override
    public <T> boolean update(T t) {
        try{
            manager.merge(t);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public <T> boolean delete(T t) {
        try{
            manager.remove(t);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public <T> boolean create(T t) {
        try{
            manager.persist(t);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
