package ita.o2o.service;

import ita.o2o.dto.BusinessDto;

import java.util.List;

public interface RestaurantService {

	public List<BusinessDto> getRestaurantList();
	
	public List<BusinessDto> getRestaurantListByName();
	
	public List<BusinessDto> getHotRestaurantList();
}
