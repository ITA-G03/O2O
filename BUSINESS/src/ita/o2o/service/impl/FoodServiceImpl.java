package ita.o2o.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ita.o2o.dao.impl.FoodDaoImpl;
import ita.o2o.entity.base.Food;
import ita.o2o.service.FoodService;

@Service("foodService")
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodDaoImpl foodDao;
	
	
	@Override
	@Transactional
	public int createFood(Food food) {
		// TODO Auto-generated method stub
		int createFlag = foodDao.create(food);
		
		return createFlag;
	}

	@Override
	@Transactional
	public boolean deleteFood(Food food) {
		// TODO Auto-generated method stub
		return foodDao.delete(food);
	}

	@Override
	@Transactional
	public boolean updateFood(Food food) {
		// TODO Auto-generated method stub
		return foodDao.update(food);
	}

	@Override
	@Transactional
	public Food getById(int id) {
		// TODO Auto-generated method stub
		return foodDao.getById(id);
	}

	@Override
	@Transactional
	public List<Food> getByBusinessId(int businessId) {
		// TODO Auto-generated method stub
		List<Food> foods = foodDao.getByBusinessId(businessId);
		return foods;
	}

	

}
