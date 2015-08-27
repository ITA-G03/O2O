package ita.o2o.service;

import java.util.List;

import ita.o2o.entity.extra.FoodType;

public interface FoodTypeService {
	
	public List<FoodType> getAll() ;
	public int create(FoodType foodType) ;
	public  boolean delete(FoodType foodType) ;
	public FoodType getByName(String foodTypeName) ;
	public FoodType getById(int foodTypeId);

}
