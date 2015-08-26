package ita.o2o.service.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.dao.impl.RoleDaoImpl;
import ita.o2o.dao.impl.UserDaoImpl;
import ita.o2o.entity.base.User;
import ita.o2o.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Jason Cui
 * @version 2015-08-26
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    UserDaoImpl userDao;

    @Autowired
    RoleDaoImpl roleDao;

    @Override
    @Transactional
    public int registerCustomer(User user) {
        user.setRole(roleDao.getById(O2OConstants.ROLE_CUSTOMER));
        return userDao.create(user);
    }
}
