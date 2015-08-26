package ita.o2o.controller.restful;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.Food;
import ita.o2o.entity.extra.FoodType;
import ita.o2o.util.mapper.JSONMapper;



@Controller
public class FoodController extends BaseController{
	 
    @Autowired
	private JSONMapper mapper;
    
	//列出所有的食品
	@ResponseBody
	@RequestMapping(value="business/food/list",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public List<Food> getFoods(Model model) {
		List<Food> foods = null;
		
		foods = new ArrayList<Food>();
		Food f1 = new Food();
		f1.setFoodId(2);
		f1.setFoodName("main");
		f1.setFoodPictureId(1223);
		f1.setPrice(12);
		foods.add(f1);
		
		model.addAttribute("foods",foods);
		
		return foods;
		
	}

	
	//查看某个食品的详细信息
	@ResponseBody
	@RequestMapping(value="/business/{businessId}/food{foodId}/detail",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public Food loadById(@PathVariable int businessId,@PathVariable int foodId,Model model) {
		Food food = null;
		
		food = new Food();
	
		food.setPrice(2);
		
		
		model.addAttribute("food",food);
		return food;
		
	}
	
	//更新某个食品
	@ResponseBody
	@RequestMapping(value="/business/food/update",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public String updateFood(@PathVariable int businessId,@PathVariable int foodId,Food food,Model model) {
		
		model.addAttribute("food",food);
		
		return "update";
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/business/food/type",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public FoodType getFoodType(Model model) {
		FoodType foodType =new FoodType();
		foodType.setFoodTypeId(1);
		foodType.setFoodTypeName("main");
		model.addAttribute("foodType", foodType);
		return foodType;
		
	}
	

}