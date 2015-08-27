package ita.o2o.controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ita.o2o.constants.O2OConstants;
import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.Food;
import ita.o2o.entity.extra.FoodType;
import ita.o2o.service.impl.FoodServiceImpl;
import ita.o2o.service.impl.FoodTypeServiceImpl;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;

@Controller
@RequestMapping("/action")
public class FoodActionController extends BaseController{
	
	@Autowired
	private JSONMapper mapper;
	
	@Autowired
	private FoodServiceImpl foodService;
	
	@Autowired
	private FoodTypeServiceImpl foodTypeService;
	
	//添加一个食品
		@ResponseBody
		@RequestMapping(value="food/create",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
		public String addFood(Model model) {
			Food food = new Food();
			food.setFoodName("main");
			int m = foodService.createFood(food);
			model.addAttribute("food", food);
			ResponseMessage message = new ResponseMessage();
			message.setStatus("success");
			return mapper.writeObjectAsString(message);	
		}
		
		//删除某个食品
		@ResponseBody
		@RequestMapping(value="/food/delete",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
		public String deleteFood(int foodTypeId,Model model) {
			FoodType foodType = foodTypeService.getById(foodTypeId);
			boolean flag = foodTypeService.delete(foodType);
			ResponseMessage msg = new ResponseMessage();
			if(flag) {
				msg.setStatus(O2OConstants.SUCCESS);	
			}else {
				msg.setStatus(O2OConstants.FAILURE);
			}
			return mapper.writeObjectAsString(msg);	
		}
		
		//添加食物类型
		@ResponseBody
		@RequestMapping(value="/food/type/create",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
		public String createFoodType(String foodTypeName) {
			FoodType foodType = new FoodType();
			foodType.setFoodTypeName(foodTypeName);
			int m = foodTypeService.create(foodType);
			ResponseMessage msg = new ResponseMessage();
			if(m>0) {
				msg.setStatus(O2OConstants.SUCCESS);	
			}else {
				msg.setStatus(O2OConstants.FAILURE);
			}
			return mapper.writeObjectAsString(msg);	
		}
		
		
		//删除食物类型
		@ResponseBody
		@RequestMapping(value="/food/type/delete",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
		public String deleteFoodType(int foodTypeId) {
			FoodType foodType = foodTypeService.getById(foodTypeId);
			
			boolean flag = foodTypeService.delete(foodType);
			ResponseMessage msg = new ResponseMessage();
			if(flag) {
				msg.setStatus(O2OConstants.SUCCESS);	
			}else {
				msg.setStatus(O2OConstants.FAILURE);
			}
			return mapper.writeObjectAsString(msg);	
		}
		
		//查询类型是否存在 
		@ResponseBody
		@RequestMapping(value="/food/type/find",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
		public String findFoodType(String foodTypeName) {
			FoodType foodType = foodTypeService.getByName(foodTypeName);
			ResponseMessage msg = new ResponseMessage();
			if(foodType!=null) {
				msg.setStatus(O2OConstants.SUCCESS);	
			}else {
				msg.setStatus(O2OConstants.FAILURE);
			}
			return mapper.writeObjectAsString(msg);
			
		}
		
		
		

}
