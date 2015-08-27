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
		BusinessDto businessDto = (BusinessDto)session.getAttribute("currentRestaurant");
		if(null != businessDto){
			return jsonMapper.writeObjectAsString(restaurantService.getRestaurantDetail(businessDto.getId()));
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value="/list/comment", method = RequestMethod.GET)
	public String showComment(HttpSession session){
		BusinessDto businessDto = (BusinessDto)session.getAttribute("currentRestaurant");
		if(null != businessDto){
			return jsonMapper.writeObjectAsString(restaurantService.getRestaurantComment(businessDto.getId()));
		}
		return null;
	}


}
