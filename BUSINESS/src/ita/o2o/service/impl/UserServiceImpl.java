package ita.o2o.service.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.dao.impl.UserDaoImpl;
import ita.o2o.entity.base.User;
import ita.o2o.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Jason Cui
 * @version 2015-08-26
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDaoImpl userDao;


    @Override
    public User findByTel(String tel) {
        return userDao.findByTel(tel);
    }


    @Override
    public User getById(Integer id){
        return  userDao.getById(id);
    }

    @Override
    public int login(String tel, String encryptedPassword) {
        User user=userDao.findByTel(tel);
        if(user==null){
            return O2OConstants.LOGIN_USER_NOT_EXIST;
        }
        else if(!user.getEncryptedPassword().equals(encryptedPassword)){
            return O2OConstants.LOGIN_PASSWORD_WRONG;
        }
        else if(user.getEncryptedPassword().equals(encryptedPassword)){
            System.out.println("Login Success~");
            return O2OConstants.LOGIN_SUCCESS;
        }
        return O2OConstants.LOGIN_USER_NOT_EXIST;
    }

    @Override
    @Transactional
    public int updatePassword(int userId, String oldPassword, String newPassword) {
        User user=userDao.getById(userId);
        if(!user.getEncryptedPassword().equals(oldPassword)){
            return O2OConstants.USER_UPDATE_OLD_PASSWORD_WRONG;
        }
        else{
            user.setEncryptedPassword(newPassword);
            return userDao.update(user)?O2OConstants.USER_UPDATE_SUCCESS:O2OConstants.DEFAULT_FAILURE_CODE;
        }
    }
}
