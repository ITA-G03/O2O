package ita.o2o.service.impl;

import ita.o2o.dao.impl.LocationDaoImpl;
import ita.o2o.entity.location.Location;
import ita.o2o.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by ZHANGJA4 on 8/27/2015.
 */
@Service("locationService")
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationDaoImpl locationDao;

    @Override
    public Location getById(Integer id) {
        return locationDao.getById(id);
    }

    @Override
    @Transactional
    public boolean update(Location location){
        return  locationDao.update(location);
    }
}
