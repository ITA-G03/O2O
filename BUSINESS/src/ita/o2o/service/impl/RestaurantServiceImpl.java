package ita.o2o.service.impl;

import java.util.List;

import ita.o2o.dto.BusinessDto;
import ita.o2o.dto.CommentDto;
import ita.o2o.service.RestaurantService;
import org.springframework.stereotype.Service;

@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {

	@Override
	public List<BusinessDto> getRestaurantList() {
		System.out.print("restaurantList");
		return null;
	}

	@Override
	public List<BusinessDto> getRestaurantListByName(String storeName) {
		System.out.print("restaurantListByName");
		return null;
	}

	@Override
	public List<BusinessDto> getHotRestaurantList() {
		System.out.print("hot restaurantList");
		return null;
	}

	@Override
	public BusinessDto getRestaurantDetail(int businessId) {
		System.out.print("detail restaurantList");
		return null;
	}

	@Override
	public CommentDto getRestaurantComment(int businessId) {
		System.out.print("comment restaurantList");
		return null;
	}


}
