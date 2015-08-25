package ita.o2o.service;

import ita.o2o.dto.BusinessDto;
import ita.o2o.dto.CommentDto;

import java.util.List;

public interface RestaurantService {

	public List<BusinessDto> getRestaurantList();
	
	public List<BusinessDto> getRestaurantListByName(String storeName);
	
	public List<BusinessDto> getHotRestaurantList();

	public BusinessDto getRestaurantDetail(int businessId);

	public CommentDto getRestaurantComment(int businessId);
}
