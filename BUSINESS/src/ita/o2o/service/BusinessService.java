package ita.o2o.service;

import ita.o2o.entity.base.Business;

import java.util.List;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
public interface BusinessService {
    int createBusiness(Business business);

//    boolean deleteBusiness(Business business);

    boolean updateBusiness(Business business);

    Business getById(int id);

    List<Business> getAll();
}
