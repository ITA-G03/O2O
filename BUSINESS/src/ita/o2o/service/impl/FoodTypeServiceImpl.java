package ita.o2o.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ita.o2o.dao.impl.FoodTypeImpl;
import ita.o2o.entity.extra.FoodType;
import ita.o2o.service.FoodTypeService;

@Service("foodTypeService")
public class FoodTypeServiceImpl implements FoodTypeService {

	@Autowired
	FoodTypeImpl foodTypeDao;
	
	@Override
	@Transactional
	public List<FoodType> getAll() {
		// TODO Auto-generated method stub
		return foodTypeDao.getAll();
	}

	@Override
	@Transactional
	public int create(FoodType foodType) {
		// TODO Auto-generated method stub
		return foodTypeDao.create(foodType);
	}

	@Override
	@Transactional
	public boolean delete(FoodType foodType) {
		// TODO Auto-generated method stub
		return foodTypeDao.delete(foodType);
	}

	@Override
	public FoodType getByName(String foodTypeName) {
		// TODO Auto-generated method stub
		return foodTypeDao.getByName(foodTypeName);
	}

	@Override
	public FoodType getById(int foodTypeId) {
		// TODO Auto-generated method stub
		return foodTypeDao.getById(foodTypeId);
	}
	
	

}
