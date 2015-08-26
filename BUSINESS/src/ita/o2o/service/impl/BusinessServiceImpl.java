package ita.o2o.service.impl;


import ita.o2o.dao.impl.BusinessDaoImpl;
import ita.o2o.entity.base.Business;
import ita.o2o.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WhiteSaber on 15/8/26.
 */
@Service("businessService")
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    BusinessDaoImpl businessDao;

    @Override
    public int createBusiness(Business business) {
        int createFlag = businessDao.create(business);
        System.out.println("Service Create Flag:" + createFlag);
        System.out.println("Id:" + business.getBusinessId());
        System.out.println("Name:" + business.getRealName());
        return createFlag;
    }


    @Override
    public boolean updateBusiness(Business business) {
        return businessDao.update(business);
    }

    @Override
    public Business getById(int id) {
        return businessDao.getById(id);
    }

    @Override
    public List<Business> getAll() {
        return businessDao.getAll();
    }
}
