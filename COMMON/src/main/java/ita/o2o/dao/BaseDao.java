package ita.o2o.dao;

import java.util.List;

/**
 * 泛型类基本增删改查DAO
 * @author Jason Cui
 * @version 2015-08-25
 */
public interface BaseDao<T> {
    T getById(Class<T> c,int id);//暂时没法化简到 T getById(int id);
    T getByName(String name);
    List<T> getAll();

    boolean create(T t);
    boolean delete(T t);
    boolean update(T t);
}
