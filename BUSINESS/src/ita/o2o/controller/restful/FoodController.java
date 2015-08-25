package ita.o2o.controller.restful;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ita.o2o.entity.base.Food;



@Controller
public class FoodController {
	 
	
	
	//添加一个食品
	@ResponseBody
	@RequestMapping(value="/business/create",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public String addFood(Model model) {
		Food food = new Food();
		model.addAttribute("food", food);
		
		
		return "success";	
	}
	
	//列出所有的食品
	@ResponseBody
	@RequestMapping(value="/business{businessId}/food/list",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public List<Food> getFoods(@PathVariable int businessId,Model model) {
		List<Food> foods = null;
		
		foods = new ArrayList<Food>();
		Food f1 = new Food();
		
		foods.add(f1);
		
		model.addAttribute("foods",foods);
		
		return foods;
		
	}
	
	
	
	//按照类型列出所有食品
	@ResponseBody
	@RequestMapping(value="/business{businessId}/food{food_type}/list",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public List<Food> getFoodsByType(int businessId,int food_type,Model model) {
		List<Food> foods = null;
		
		
		foods = new ArrayList<Food>();
		Food f1 = new Food();
		
		foods.add(f1);
		
		model.addAttribute("foods", foods);
		
		
		return foods;
	}
	
	
	//查看某个食品的详细信息
	@ResponseBody
	@RequestMapping(value="/business{businessId}/food{foodId}/detail",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public Food loadById(@PathVariable int businessId,@PathVariable int foodId,Model model) {
		Food food = null;
		
		food = new Food();
	
		food.setPrice(2);
		
		
		model.addAttribute("food",food);
		return food;
		
	}
	
	
	//更新某个食品
	@ResponseBody
	@RequestMapping(value="/business{businessId}/food{foodId}/update",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public String updateFood(@PathVariable int businessId,@PathVariable int foodId,Food food,Model model) {
		
		model.addAttribute("food",food);
		
		return "update";
		
	}
	
	//删除某个食品
	@ResponseBody
	@RequestMapping(value="/business{businessId}/food{foodId}/delete",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public String deleteFood(@PathVariable int businessId,@PathVariable int foodId,Model model) {
		
		
		return "delete";
	}
	

}