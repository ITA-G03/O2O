package ita.o2o.service.impl;

import ita.o2o.dao.impl.BusinessTagDaoImpl;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.BusinessTag;
import ita.o2o.service.BusinessTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-27
 */
@Service("businessTagService")
public class BusinessTagServiceImpl implements BusinessTagService {
    @Autowired
    BusinessTagDaoImpl businessTagDao;

    @Override
    public BusinessTag getById(int id) {
        return businessTagDao.getById(id);
    }

    @Override
    public List<BusinessTag> getAll() {
        return businessTagDao.getAll();
    }


    @Override
    public List<BusinessTag> getByBusiness(Business business) {
        return businessTagDao.getByBusiness(business);
    }
}
