package ita.o2o.service;

import java.util.List;

import ita.o2o.entity.base.Food;
import ita.o2o.entity.location.Area;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
public interface FoodService {
	
		int createFood(Food food);
	    boolean deleteFood(Food food);
	    boolean updateFood(Food food);


	    Food getById(int id);
	    public List<Food> getByBusinessId(int businessId);
	    
}
