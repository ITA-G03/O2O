package ita.o2o.dao.impl;

import ita.o2o.entity.base.Business;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by YUKE on 8/25/2015.
 */

@Component("restaurantDao")
public class RestaurantDaoImpl extends BaseDaoImpl<Business> {





    public List<Business> getHotRestaurantList(int businessStatusId){
        String hql = "FROM Business B WHERE B.businessId =:statusId";
        Query query = this.getManager().createQuery(hql);
        query.setParameter("statusId", businessStatusId);
        return query.getResultList();
    }

    public List<Business> autoCompleteByName(String name){
        //just yy
        String hql = "FROM Business B WHERE B.realName like % :name %";
        Query query = this.getManager().createQuery(hql);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public <T> T getById(int id) {
        return null;
    }
}

