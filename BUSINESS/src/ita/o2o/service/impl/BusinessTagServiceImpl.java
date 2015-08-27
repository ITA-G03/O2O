package ita.o2o.service.impl;

import ita.o2o.dao.impl.BusinessTagDaoImpl;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.BusinessTag;
import ita.o2o.service.BusinessTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<BusinessTag> businessTagList=businessTagDao.getAll();
        for(BusinessTag businessTag:businessTagList){
            businessTag.getBusiness().setBusinessTags(new ArrayList<>());
        }
        return businessTagList;
    }


    @Override
    public List<BusinessTag> getByBusiness(Business business) {
        List<BusinessTag> businessTagList=businessTagDao.getByBusiness(business);
        for(BusinessTag businessTag:businessTagList){
            businessTag.getBusiness().setBusinessTags(new ArrayList<>());
        }
        return businessTagList;
    }
}
