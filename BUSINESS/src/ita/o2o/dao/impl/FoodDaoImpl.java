package ita.o2o.dao.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.dto.BusinessDto;
import ita.o2o.entity.base.Food;
import ita.o2o.entity.extra.FoodType;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by YUKE on 8/25/2015.
 */

@Repository("foodDao")
public class FoodDaoImpl extends BaseDaoImpl<Food> {


    @SuppressWarnings("unchecked")
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
        Object[] objs = (Object[])query.getSingleResult();
        BusinessDto businessDto = new BusinessDto(Double.parseDouble(objs[0].toString()),Double.parseDouble(objs[1].toString()));
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
    
    
    public boolean delete(Food food) {
    	  try {
	            Food ft=this.getManager().merge(food);
	            this.getManager().remove(ft);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
    }
    
    
   public boolean updateFood(Food food) {
	   String hql = "UPDATE Food food SET food.foodName=:foodName,food.price=:price where food.foodId=:foodId";
       Query query = this.getManager().createQuery(hql);
       query.setParameter("foodName",food.getFoodName());
       query.setParameter("price",food.getPrice());
       query.setParameter("foodId",food.getFoodId());
       int m = query.executeUpdate();
  System.out.println(m);
       if(m>0)
    	   return true;
       
       return false;
       
	   
   }
}
