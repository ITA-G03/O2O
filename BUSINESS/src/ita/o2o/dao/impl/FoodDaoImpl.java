package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.dto.BusinessDto;
import ita.o2o.entity.base.Food;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by YUKE on 8/25/2015.
 */

@Component("foodDao")
public class FoodDaoImpl extends BaseDaoImpl<Food> {


    public List<Food> getByBusinessId(int businessId){
        String hql = "FROM Food F WHERE F.owner.businessId = :businessId";
        Query query = this.getManager().createQuery(hql);
        query.setParameter("businessId", businessId);
        return query.getResultList();
    }

    public BusinessDto getAvgRatingAndSalesVolumeByBusinessId(int businessId){
        String hql = "SELECT AVG(F.averageRating), SUM(F.salesVolume) FROM Food F WHERE F.owner.businessId = ?";
        Query query = this.getManager().createQuery(hql);
        query.setParameter(new Integer(1), businessId);
        Object[] objs  = (Object[])query.getSingleResult();
        BusinessDto businessDto = new BusinessDto();
        if(null != objs[0]) {
            businessDto.setRating(Double.parseDouble(objs[0].toString()));
        }
        if(null != objs[1]) {
            businessDto.setSales(Double.parseDouble(objs[1].toString()));
        }
        return businessDto;
    }

    @Override
    public List<Food> getAll() {
        return null;
    }

    @Override
    public int create(Food food) {
        try{
            this.getManager().persist(food);
            return food.getFoodId();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return O2OConstants.DEFAULT_FAILURE_CODE;
    }
}
