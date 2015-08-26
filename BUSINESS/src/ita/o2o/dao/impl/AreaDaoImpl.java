package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.location.Area;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public  List<Area> getAll() {
        CriteriaBuilder criteriaBuilder=this.getManager().getCriteriaBuilder();
        CriteriaQuery<Area> criteriaQuery=criteriaBuilder.createQuery(Area.class);
        Root<Area> root=criteriaQuery.from(Area.class);
        List<Area> resultList=this.getManager().createQuery(criteriaQuery).getResultList();
        return resultList;
    }

    @Override
    public int create(Area area) {
        try{
            this.getManager().persist(area);
            return area.getAreaId();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return O2OConstants.DEFAULT_FAILURE_CODE;
    }
}
