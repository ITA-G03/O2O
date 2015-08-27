package ita.o2o.service;

import ita.o2o.entity.base.User;

import java.util.List;

public interface UserService {
	List<User> query();
	boolean update(String tel);
}
