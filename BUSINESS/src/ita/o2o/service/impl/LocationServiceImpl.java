package ita.o2o.service.impl;

import ita.o2o.dao.impl.LocationDaoImpl;
import ita.o2o.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZHANGJA4 on 8/27/2015.
 */
@Service("locationService")
public class LocationServiceImpl implements LocationService{
    @Autowired
    LocationDaoImpl locationDao;


}
