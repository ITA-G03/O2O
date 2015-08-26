package ita.o2o.dao.impl;

import ita.o2o.entity.location.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-25
 */
@Repository("areaDao")
public class AreaDaoImpl extends BaseDaoImpl<Area>{


    @Override
    public <T> T getById(int id) {
        return null;
    }

    @Override
    public <T> List<T> getAll() {
        return null;
    }
}
