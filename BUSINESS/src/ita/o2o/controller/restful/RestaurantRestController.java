package ita.o2o.controller.restful;

import ita.o2o.dto.BusinessDto;

import java.util.ArrayList;
import java.util.List;

import ita.o2o.dto.CommentDto;
import ita.o2o.dto.FoodDto;
import ita.o2o.service.RestaurantService;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="rest/restaurant",produces = "application/json; charset=utf-8")
public class RestaurantRestController {

	@Autowired
	JSONMapper jsonMapper;

	@Autowired
	RestaurantService restaurantService;
	
	@ResponseBody
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String showRestaurantList(){
		restaurantService.getRestaurantList();
		return jsonMapper.writeObjectAsString(init());
	}
	
	@ResponseBody
	@RequestMapping(value="/list/{storeName}", method = RequestMethod.PUT)
	public List<BusinessDto> searchRestaurant(@PathVariable String storeName){
		restaurantService.getRestaurantListByName(storeName);
		return null;
	}

	@ResponseBody
	@RequestMapping(value="/list/hot", method = RequestMethod.GET)
	public List<BusinessDto> showHotRestaurant(){
		restaurantService.getHotRestaurantList();
		return null;
	}

	@ResponseBody
	@RequestMapping(value="/{businessId}/detail", method = RequestMethod.GET)
	public String showDetail(@PathVariable int businessId){
		restaurantService.getRestaurantDetail(businessId);
		BusinessDto b = new BusinessDto(1,"img/res.jpg","炸Tomcat",4.3,43,20,"30");
		b.setFoodList(initFood());
		return jsonMapper.writeObjectAsString(b);
	}

	@ResponseBody
	@RequestMapping(value="/{businessId}/list/comment", method = RequestMethod.GET)
	public String showComment(@PathVariable int businessId){
		restaurantService.getRestaurantComment(businessId);
		return jsonMapper.writeObjectAsString(initComment());
	}

	public List<BusinessDto> init(){
		System.out.println();
		List<BusinessDto> bs = new ArrayList<BusinessDto>();
		BusinessDto b = new BusinessDto(1,"images/res.jpg","炸Tomcat",0.7,21,20,"30");
		BusinessDto b1 = new BusinessDto(1,"images/res1.jpg","Tomcat汉堡",1,33,20,"30");
		BusinessDto b2 = new BusinessDto(1,"images/res2.jpg","Tomcat肉",2,43,20,"30");
		BusinessDto b3 = new BusinessDto(1,"images/res3.jpg","沙县Tomcat",3,11,20,"30");
		BusinessDto b4 = new BusinessDto(1,"images/res4.jpg","Tomcat煲",4.3,0,20,"30");
		BusinessDto b5 = new BusinessDto(1,"images/res.jpg","炸Tomcat",5,43,1,"30");
		BusinessDto b6 = new BusinessDto(1,"images/res1.jpg","Tomcat汉堡",3,10,20,"30");
		BusinessDto b7 = new BusinessDto(1,"images/res2.jpg","Tomcat肉",2.3,43,20,"30");
		BusinessDto b8 = new BusinessDto(1,"images/res3.jpg","沙县Tomcat",4,9,20,"30");
		BusinessDto b9 = new BusinessDto(1,"images/res4.jpg","Tomcat煲",4.3,43,20,"30");
		bs.add(b);
		bs.add(b1);
		bs.add(b2);
		bs.add(b3);
		bs.add(b4);
		bs.add(b5);
		bs.add(b6);
		bs.add(b7);
		bs.add(b8);
		bs.add(b9);
		return bs;
	}

	public List<FoodDto> initFood(){
		List<FoodDto> foods = new ArrayList<FoodDto>();
		FoodDto fd = new FoodDto(1, "红烧狮子头", 1, 9.9, 999, "主食");
		FoodDto fd1 = new FoodDto(2, "红烧狮子头2", 1, 9.9, 999, "主食");
		FoodDto fd2 = new FoodDto(3, "红烧狮子头3", 1, 9.9, 999, "主食");
		FoodDto fd3 = new FoodDto(4, "红烧狮子头4", 1, 9.9, 999, "主食");
		FoodDto fd4 = new FoodDto(5, "香辣Tomcat堡", 1, 9.9, 999, "饮料");
		FoodDto fd5 = new FoodDto(6, "炸Tomcat堡", 1, 9.9, 999, "主食");
		FoodDto fd6 = new FoodDto(7, "Tomcat卷", 1, 9.9, 999, "主食");
		FoodDto fd7 = new FoodDto(8, "新奥尔良Tomcat腿", 1, 9.9, 999, "主食");
		FoodDto fd8 = new FoodDto(9, "红烧狮子头", 1, 9.9, 999, "主食");
		FoodDto fd9 = new FoodDto(10, "红烧狮子头2", 1, 9.9, 999, "主食");
		FoodDto fd10 = new FoodDto(11, "红烧狮子头3", 1, 9.9, 999, "主食");
		FoodDto fd11 = new FoodDto(12, "红烧狮子头4", 1, 9.9, 999, "主食");
		FoodDto fd12 = new FoodDto(13, "香辣Tomcat堡", 1, 9.9, 999, "饮料");
		FoodDto fd13 = new FoodDto(14, "炸Tomcat堡", 1, 9.9, 999, "主食");
		FoodDto fd14 = new FoodDto(15, "Tomcat卷", 1, 9.9, 999, "主食");
		FoodDto fd15 = new FoodDto(16, "新奥尔良Tomcat腿", 1, 9.9, 999, "主食");
		foods.add(fd);
		foods.add(fd1);
		foods.add(fd2);
		foods.add(fd3);
		foods.add(fd4);
		foods.add(fd5);
		foods.add(fd6);
		foods.add(fd7);
		foods.add(fd8);
		foods.add(fd9);
		foods.add(fd10);
		foods.add(fd11);
		foods.add(fd12);
		foods.add(fd13);
		foods.add(fd14);
		foods.add(fd15);
		return foods;
	}

	public List<CommentDto> initComment(){
		List<CommentDto> cds = new ArrayList<CommentDto>();
		CommentDto cd = new CommentDto(1,4,"实在找不到比这更好吃的店铺了。。。","2015-08-24");
		CommentDto cd1 = new CommentDto(1,4,"老板为什么我的鸡米花套餐少了鸡米花","2015-08-24");
		CommentDto cd2 = new CommentDto(1,4,"实在找不到比这更好吃的店铺了。。。","2015-08-24");
		CommentDto cd3 = new CommentDto(1,4,"老板为什么我的鸡米花套餐少了鸡米花","2015-08-24");
		CommentDto cd4 = new CommentDto(1,4,"实在找不到比这更好吃的店铺了。。。","2015-08-24");
		CommentDto cd5 = new CommentDto(1,4,"老板为什么我的鸡米花套餐少了鸡米花","2015-08-24");
		CommentDto cd6 = new CommentDto(1,4,"实在找不到比这更好吃的店铺了。。。","2015-08-24");
		CommentDto cd7 = new CommentDto(1,4,"老板为什么我的鸡米花套餐少了鸡米花","2015-08-24");
		CommentDto cd8 = new CommentDto(1,4,"实在找不到比这更好吃的店铺了。。。","2015-08-24");
		CommentDto cd9 = new CommentDto(1,4,"老板为什么我的鸡米花套餐少了鸡米花","2015-08-24");
		cds.add(cd);
		cds.add(cd1);
		cds.add(cd2);
		cds.add(cd3);
		cds.add(cd4);
		cds.add(cd5);
		cds.add(cd6);
		cds.add(cd7);
		cds.add(cd8);
		cds.add(cd9);
		return cds;
	}
	
}
