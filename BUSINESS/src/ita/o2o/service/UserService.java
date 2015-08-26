package ita.o2o.service;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
public interface UserService {

    int login(String tel,String encryptedPassword);
}
