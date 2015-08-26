package ita.o2o.service.impl;

import java.util.ArrayList;
import java.util.List;

import ita.o2o.constants.O2OConstants;
import ita.o2o.dao.impl.CommentDaoImpl;
import ita.o2o.dao.impl.FoodDaoImpl;
import ita.o2o.dao.impl.RestaurantDaoImpl;
import ita.o2o.dto.BusinessDto;
import ita.o2o.dto.CommentDto;
import ita.o2o.dto.FoodDto;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.Comment;
import ita.o2o.entity.base.Food;
import ita.o2o.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantDaoImpl restaurantDao;

	@Autowired
	FoodDaoImpl foodDao;

	@Autowired
	CommentDaoImpl commentDao;

	@Override
	public List<BusinessDto> getRestaurantList() {
		List<Business> bs = restaurantDao.getAll();
		List<BusinessDto> businessDtos = new ArrayList<>();
		for(Business b : bs){
			BusinessDto businessDto = foodDao.getAvgRatingAndSalesVolumeByBusinessId(b.getBusinessId());
			businessDto.setId(b.getBusinessId());
			businessDto.setName(b.getRealName());
			businessDto.setLogoId(b.getLogoId());
			businessDto.setPrice(b.getSendPrice());
			businessDto.setTime(O2OConstants.BUSINESS_DELIVERY_TIME);
			businessDtos.add(businessDto);
		}
		return businessDtos;
	}

	@Override
	public List<BusinessDto> getRestaurantListByName(String storeName) {
		List<Business> bs = restaurantDao.autoCompleteByName(storeName);
		List<BusinessDto> businessDtos = new ArrayList<>();
		for(Business b : bs){
			BusinessDto businessDto = new BusinessDto();
			businessDto.setId(b.getBusinessId());
			businessDto.setName(b.getRealName());
			businessDtos.add(businessDto);
		}
		return businessDtos;
	}

	@Override
	public List<Business> getHotRestaurantList() {
		return restaurantDao.getHotRestaurantList(O2OConstants.BUSINESS_STATUS_HOT);
	}

	@Override
	public BusinessDto getRestaurantDetail(int businessId) {
		List<Food> foods = foodDao.getByBusinessId(businessId);
		BusinessDto businessDto = null;
		if(foods != null){
			businessDto = foodDao.getAvgRatingAndSalesVolumeByBusinessId(businessId);
			Business business = foods.get(0).getOwner();
			businessDto.setId(businessId);
			businessDto.setName(business.getRealName());
			businessDto.setPrice(business.getSendPrice());
			businessDto.setTime(O2OConstants.BUSINESS_DELIVERY_TIME);
			businessDto.setLogoId(business.getLogoId());
			businessDto.setFoodList(foodListConvert(foods));
		}
		return businessDto;
	}

	@Override
	public List<CommentDto> getRestaurantComment(int businessId) {
		List<CommentDto> commentDtos = new ArrayList<>();
		List<Comment> comments = commentDao.getCommentListByBusinessId(businessId);
		for(Comment c : comments){
			CommentDto commentDto = new CommentDto();
			commentDto.setBody(c.getCommentContent());
			commentDto.setDate(c.getCommentTime());
//			commentDto.setRating(bu);
			commentDtos.add(commentDto);
		}
		return commentDtos;
	}

	public List<FoodDto> foodListConvert(List<Food> foods){
		List<FoodDto> foodDtos = new ArrayList<>();
		for(Food food : foods){
			FoodDto foodDto = new FoodDto();
			foodDto.setId(food.getFoodId());
			foodDto.setName(food.getFoodName());
			foodDto.setFoodPictureId(food.getFoodPictureId());
			foodDto.setPrice(food.getPrice());
			foodDto.setSales(food.getSalesVolume());
//			foodDto.setTag(food.get);
			foodDtos.add(foodDto);
		}
		return foodDtos;
	}
}
