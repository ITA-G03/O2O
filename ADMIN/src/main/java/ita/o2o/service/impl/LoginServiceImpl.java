package ita.o2o.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ita.o2o.dao.impl.AdminDaoImpl;
import ita.o2o.entity.admin.Admin;
import ita.o2o.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Autowired
	AdminDaoImpl adminDao;
	
	@Transactional
	public boolean login(Admin admin) {
		boolean flag=adminDao.query(admin);
		return flag;
	}

}
