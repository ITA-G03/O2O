package ita.o2o.service.impl;


import ita.o2o.dao.impl.BusinessDaoImpl;
import ita.o2o.dao.impl.CityDaoImpl;
import ita.o2o.dao.impl.LocationDaoImpl;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.BusinessTag;
import ita.o2o.entity.base.User;
import ita.o2o.entity.location.City;
import ita.o2o.entity.location.Location;
import ita.o2o.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by WhiteSaber on 15/8/26.
 */
@Service("businessService")
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    BusinessDaoImpl businessDao;

    @Autowired
    CityDaoImpl cityDao;

    @Autowired
    LocationDaoImpl locationDao;


    @Override
    @Transactional
    public int createBusiness(Business business) {
        int createFlag = businessDao.create(business);
        System.out.println("Service Create Flag:" + createFlag);
        System.out.println("Id:" + business.getBusinessId());
        System.out.println("Name:" + business.getRealName());
        return createFlag;
    }

    @Override
    public Business getByUser(User user) {
        return businessDao.getByUser(user);
    }

    @Override
    @Transactional
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

    @Override
    public List<Business> getAllByTag(BusinessTag businessTag) {
        List<Business> businessList= businessDao.getAllByTag(businessTag);
        for(Business business:businessList){
            business.getBusinessTags().clear();
        }
        return businessList;
    }

    @Override
    public List<Business> getAllByLocation(Location location) {
        City city=cityDao.getById(location.getCity().getCityId());
        Location mappedLocation=locationDao.getByCity(city).get(0);

        List<Business> businessList= businessDao.getAllByLocation(mappedLocation);
        for(Business business:businessList){
            business.getBusinessTags().clear();
        }
        return businessList;
    }
}
