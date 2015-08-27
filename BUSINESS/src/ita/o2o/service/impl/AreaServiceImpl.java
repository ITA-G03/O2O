package ita.o2o.service.impl;

import ita.o2o.dao.impl.AreaDaoImpl;

import ita.o2o.entity.location.Area;
import ita.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-25
 */

@Service("areaService")
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaDaoImpl areaDao;

    @Override
    @Transactional
    public int createArea(Area area) {
        int createFlag= areaDao.create(area);
        System.out.println("Service Create Flag:"+createFlag);
        System.out.println("Id:"+area.getAreaId());
        System.out.println("Name:"+area.getAreaName());
        return createFlag;
    }

    @Override
    public boolean deleteArea(Area area) {
        return false;
    }

    @Override
    public boolean updateArea(Area area) {
        return false;
    }

    @Override
    public Area getById(int id) {
        return areaDao.getById(id);
    }

    @Override
    @Transactional
    public List<Area> getAll() {
        return areaDao.getAll();
    }


}
