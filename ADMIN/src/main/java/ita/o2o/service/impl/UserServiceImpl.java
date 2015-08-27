package ita.o2o.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ita.o2o.dao.impl.UserDaoImpl;
import ita.o2o.entity.base.User;
import ita.o2o.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDaoImpl userDao;

	@Transactional
	public List<User> query() {
		List<User> userList = userDao.query();
		return userList;
	}
	
	@Transactional
	public boolean update(String tel) {
		int id = userDao.getIdByTel(tel);
		boolean flag = userDao.update(id);
		return flag;
	}

}
