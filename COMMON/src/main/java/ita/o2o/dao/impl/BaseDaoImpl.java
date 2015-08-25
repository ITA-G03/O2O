package ita.o2o.dao.impl;

import ita.o2o.dao.BaseDao;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-25
 */
@Component("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {

    @PersistenceContext(unitName = "o2oPersistenceUnit")
    private EntityManager manager;


    @Override
    public T getById(Class<T> c, int id) {
        try{
            return manager.find(c,id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public T getByName(String name) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }


    //增删改部分
    @Override
    public boolean create(T t) {
        try{
            manager.persist(t);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(T t) {
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
    public boolean update(T t) {
        try{
            manager.merge(t);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
