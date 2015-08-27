package ita.o2o.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.extra.FoodType;

@Repository("foodTypeDao")
public class FoodTypeImpl extends BaseDaoImpl<FoodType> {

	@Override
	public List<FoodType> getAll() {
		 CriteriaBuilder criteriaBuilder=this.getManager().getCriteriaBuilder();
	        CriteriaQuery<FoodType> criteriaQuery=criteriaBuilder.createQuery(FoodType.class);
	        Root<FoodType> root=criteriaQuery.from(FoodType.class);
	        List<FoodType> resultList=this.getManager().createQuery(criteriaQuery).getResultList();
	        return resultList;
	}

	@Override
	public int create(FoodType foodType) {
		  try{
	            this.getManager().persist(foodType);
	            return foodType.getFoodTypeId();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
	        return O2OConstants.DEFAULT_FAILURE_CODE;
	}
	
	public  boolean delete(FoodType foodType) {
	        try {
	            FoodType ft=this.getManager().merge(foodType);
	            this.getManager().remove(ft);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	public FoodType getByName(String foodTypeName) {
		String sql = "from FoodType where foodTypeName=:foodTypeName";
		Query q = this.getManager().createQuery(sql);
		q.setParameter("foodTypeName",foodTypeName);
		Object o = q.getSingleResult();
		if(o==null) return null;
		FoodType foodType = (FoodType)o;
		
        return foodType;
    }
	
	public FoodType getById(int foodTypeId) {
		FoodType foodType = this.getManager().find(FoodType.class,foodTypeId);
		if(foodType==null) return null;
        return foodType;
	}
	
	public boolean findById(int foodTypeId) {
		String hql="select count(*) from Food f where f.foodType.foodTypeId=:foodTypeId";
		Query q = this.getManager().createQuery(hql);
		q.setParameter("foodTypeId",foodTypeId);
		Object o = q.getSingleResult();
		long number = (long)o;
		if(number>0) {
			return true;
		}else
			return false;
		
	}

}
