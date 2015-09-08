package ita.o2o.service;

import ita.o2o.entity.location.Area;

import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-25
 */
public interface AreaService {
    int createArea(Area area);
    boolean deleteArea(Area area);
    boolean updateArea(Area area);

    Area getById(int id);
    List<Area> getAll();
}
