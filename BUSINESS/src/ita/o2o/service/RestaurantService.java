package ita.o2o.service;

import ita.o2o.dto.BusinessDto;
import ita.o2o.dto.CommentDto;
import ita.o2o.entity.base.Business;

import java.util.List;

public interface RestaurantService {

	public List<BusinessDto> getRestaurantList();
	
	public List<Business> getRestaurantListByName(String storeName);
	
	public List<Business> getHotRestaurantList();

	public BusinessDto getRestaurantDetail(int businessId);

	public List<CommentDto> getRestaurantComment(int businessId);
}
