package ita.o2o.service;

import ita.o2o.entity.location.City;

import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-27
 */
public interface CityService {
    int createCity(City city);

    City getById(int id);
    List<City> getAll();
}
