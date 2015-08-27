package ita.o2o.service.impl;

import ita.o2o.dao.impl.CityDaoImpl;
import ita.o2o.entity.location.City;
import ita.o2o.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-27
 */
@Service("cityService")
public class CityServiceImpl implements CityService {
    @Autowired
    CityDaoImpl cityDao;

    @Override
    public int createCity(City city) {
        return cityDao.create(city);
    }

    @Override
    public City getById(int id) {
        return cityDao.getById(id);
    }

    @Override
    public List<City> getAll() {
        return cityDao.getAll();
    }
}
