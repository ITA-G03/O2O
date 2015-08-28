package ita.o2o.service;

import ita.o2o.entity.location.Location;

/**
 * Created by ZHANGJA4 on 8/27/2015.
 */
public interface LocationService {

    Location getById(Integer id);

    boolean update(Location location);
}
