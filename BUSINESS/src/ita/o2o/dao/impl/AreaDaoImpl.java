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


    public AreaDaoImpl() {
        super(Area.class);
    }


    @Override
    public <T> List<T> getAll() {
        return null;
    }
}
