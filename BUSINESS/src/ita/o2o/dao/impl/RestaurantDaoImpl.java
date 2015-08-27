package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
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
        String hql = "FROM Business B WHERE B.realName like :name";
        Query query = this.getManager().createQuery(hql);
        query.setParameter("name", "%"+name+"%");
        return query.getResultList();
    }

    @Override
    public List<Business> getAll() {
        String hql = "FROM Business";
        Query query = this.getManager().createQuery(hql);
        return query.getResultList();
    }

    @Override
    public int create(Business business) {
        try{
            this.getManager().persist(business);
            return business.getBusinessId();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return O2OConstants.DEFAULT_FAILURE_CODE;
    }
}

