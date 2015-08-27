package ita.o2o.service;

import ita.o2o.dto.BusinessDto;
import ita.o2o.entity.base.Food;

import java.util.List;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
public interface FoodService {

    int createFood(Food food);

    boolean deleteFood(Food food);

    boolean updateFood(Food food);

    Food getById(int id);

    List<Food> getByBusinessId(int businessId);

    BusinessDto getAvgRatingAndSalesVolumeByBusinessId(int businessId);
}
