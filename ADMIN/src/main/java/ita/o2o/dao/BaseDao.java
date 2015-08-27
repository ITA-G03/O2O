package ita.o2o.dao;

import java.util.List;

/**
 * 泛型类基本增删改查DAO
 * @author Jason Cui
 * @version 2015-08-25
 */
public interface BaseDao<T> {
    <T>T getById(Class<T> c,int id);//暂时没法化简到 T getById(int id);
    <T>T getById(int id);
    <T>T getByName(String name);
    List<T> getAll();

    int create(T t);
    <T> boolean delete(T t);
    <T> boolean update(T t);
}
