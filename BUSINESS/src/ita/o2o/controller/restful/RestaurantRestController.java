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

import javax.servlet.http.HttpSession;


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
		return jsonMapper.writeObjectAsString(restaurantService.getRestaurantList());
	}
	
	@ResponseBody
	@RequestMapping(value="/list/{storeName}", method = RequestMethod.GET)
	public String searchRestaurant(@PathVariable String storeName){
		return jsonMapper.writeObjectAsString(restaurantService.getRestaurantListByName(storeName));
	}

	@ResponseBody
	@RequestMapping(value="/list/hot", method = RequestMethod.GET)
	public String showHotRestaurant(){
		return jsonMapper.writeObjectAsString(restaurantService.getHotRestaurantList());
	}

	@ResponseBody
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String showDetail(HttpSession session){
		Integer businessId = (Integer)session.getAttribute("currentRestaurant");
		if(null != businessId){
			BusinessDto businessDto = restaurantService.getRestaurantDetail(businessId);
			return jsonMapper.writeObjectAsString(businessDto);
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value="/list/comment", method = RequestMethod.GET)
	public String showComment(HttpSession session){
		Integer businessId = (Integer)session.getAttribute("currentRestaurant");
		if(null != businessId){
			return jsonMapper.writeObjectAsString(restaurantService.getRestaurantComment(businessId));
		}
		return null;
	}
}
