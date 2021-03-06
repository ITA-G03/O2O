package ita.o2o.controller.restful;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.Food;
import ita.o2o.entity.base.User;
import ita.o2o.entity.extra.FoodType;
import ita.o2o.service.impl.BusinessServiceImpl;
import ita.o2o.service.impl.FoodServiceImpl;
import ita.o2o.service.impl.FoodTypeServiceImpl;
import ita.o2o.util.mapper.JSONMapper;



@Controller
public class FoodController extends BaseController{
	 
    @Autowired
	private JSONMapper mapper;
    @Autowired
    private FoodServiceImpl foodService;
    @Autowired
    private BusinessServiceImpl businessService;
    @Autowired
    private FoodTypeServiceImpl foodTypeService;
 
    
	//列出所有的食品
	@ResponseBody
	@RequestMapping(value="business/food/list",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public List<Food> getFoods(Model model,HttpSession session) {
		List<Food> foods = null;
		User user = (User)session.getAttribute("user");
		Business business =businessService.getByUser(user); 
		foods = foodService.getByBusinessId(business.getBusinessId());
		//foods = foodService.getByBusinessId(22);
		//System.out.println(foods.size());
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
	
	
	
	//列出所有的食物类型
	@ResponseBody
	@RequestMapping(value="/business/food/type",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public List<FoodType> getFoodType(Model model) {
		List<FoodType> foodTypes = foodTypeService.getAll();
		model.addAttribute("foodTypes", foodTypes);
		return foodTypes;	
	}
	

}