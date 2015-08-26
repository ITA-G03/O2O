package ita.o2o.dao.impl;

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
        String hql = "FROM Food F WHERE F.owner.businessId =: businessId";
        Query query = this.getManager().createQuery(hql);
        query.setParameter("businessId", businessId);
        return query.getResultList();
    }

    public BusinessDto getAvgRatingAndSalesVolumeByBusinessId(int businessId){
        String sql = "SELECT AVG(AVG_RATING) rating, SUM(SALES_VOLUME) sales FROM FOOD WHERE BUSINESS_ID = ?";
        Query query = this.getManager().createNativeQuery(sql);
        query.setParameter(1, businessId);
        return (BusinessDto)query.getSingleResult();
    }


}
