package ita.o2o.service;

import ita.o2o.entity.base.User;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
public interface UserService {
    User findByTel(String tel);


    User getById(Integer id);

    int login(String tel,String encryptedPassword);

    int updatePassword(int userId,String oldPassword, String newPassword);
}
