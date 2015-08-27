package ita.o2o.service.impl;

import ita.o2o.dao.impl.FoodDaoImpl;
import ita.o2o.dto.BusinessDto;
import ita.o2o.entity.base.Food;
import ita.o2o.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("foodService")
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodDaoImpl foodDao;
	
	
	@Override
	@Transactional
	public int createFood(Food food) {
		int createFlag = foodDao.create(food);
		
		return createFlag;
	}

	@Override
	@Transactional
	public boolean deleteFood(Food food) {
		return foodDao.delete(food);
	}

	@Override
	@Transactional
	public boolean updateFood(Food food) {
		return foodDao.update(food);
	}

	@Override
	@Transactional
	public Food getById(int id) {
		return foodDao.getById(id);
	}

	@Override
	@Transactional
	public List<Food> getByBusinessId(int businessId) {
		List<Food> foods = foodDao.getByBusinessId(businessId);
		return foods;
	}

    @Override
    public BusinessDto getAvgRatingAndSalesVolumeByBusinessId(int businessId) {
        return foodDao.getAvgRatingAndSalesVolumeByBusinessId(businessId);
    }


}
