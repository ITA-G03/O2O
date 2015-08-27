package ita.o2o.dao;

import ita.o2o.entity.base.User;

import java.util.List;

public interface UserDao {
	public List<User> query();
	public int getIdByTel(String tel);
	public boolean update(int id);
}
