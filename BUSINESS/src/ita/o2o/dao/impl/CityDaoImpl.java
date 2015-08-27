package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.location.City;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-27
 */
@Repository("cityDao")
public class CityDaoImpl extends BaseDaoImpl<City>{

    public CityDaoImpl() {
        super(City.class);
    }

    @Override
    public int create(City city) {
        try{
            this.getManager().persist(city);
            return city.getCityId();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return O2OConstants.DEFAULT_FAILURE_CODE;
    }

    @Override
    public List<City> getAll() {
        CriteriaBuilder criteriaBuilder=this.getManager().getCriteriaBuilder();
        CriteriaQuery<City> criteriaQuery=criteriaBuilder.createQuery(City.class);
        Root<City> root=criteriaQuery.from(City.class);
        List<City> resultList=this.getManager().createQuery(criteriaQuery).getResultList();
        return resultList;
    }
}
