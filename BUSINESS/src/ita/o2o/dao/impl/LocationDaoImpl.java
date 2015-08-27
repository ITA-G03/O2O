package ita.o2o.dao.impl;

import ita.o2o.entity.location.Location;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZHANGJA4 on 8/27/2015.
 */
@Repository("locationDao")
public class LocationDaoImpl extends BaseDaoImpl<Location> {

    LocationDaoImpl() {
        super(Location.class);
    }

    @Override
    public List<Location> getAll() {
        return null;
    }

    @Override
    public int create(Location location) {
        return 0;
    }
}
