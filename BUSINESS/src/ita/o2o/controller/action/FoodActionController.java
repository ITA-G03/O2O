package ita.o2o.controller.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ita.o2o.constants.O2OConstants;
import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.Food;
import ita.o2o.entity.extra.FoodType;
import ita.o2o.service.impl.BusinessServiceImpl;
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
	private BusinessServiceImpl businessService;
	
	@Autowired
	private FoodTypeServiceImpl foodTypeService;
	
	//添加一个食品
		@ResponseBody
		@RequestMapping(value="food/create",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
		public String addFood(String foodName,double price,String typeName,int foodPictureId,Model model) {
			Food food = new Food();
			System.out.println(foodName+".."+price+".."+typeName+"...."+foodPictureId);
			FoodType foodType = foodTypeService.getByName(typeName);
			food.setFoodName(foodName);
			food.setFoodType(foodType);
			food.setPrice(price);
			food.setFoodPictureId(foodPictureId);
			food.setAverageRating(0);
			food.setSalesVolume(0);
			Business owner = businessService.getById(22);
			food.setOwner(owner);
			model.addAttribute("food", food);
			int m = foodService.createFood(food);
			ResponseMessage message = new ResponseMessage();
			Map<String,String> body = new HashMap<String,String>();
			if(m>0) {
				message.setStatus(O2OConstants.SUCCESS);
				body.put(O2OConstants.SUCCESS,"add food success!");
				message.setBody(body);
			}else {
				message.setStatus(O2OConstants.FAILURE);
				body.put(O2OConstants.FAILURE, "add food failure!!");
			}
			return mapper.writeObjectAsString(message);	
		}
		
		//删除某个食品
		@ResponseBody
		@RequestMapping(value="/food/delete",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
		public String deleteFood(int foodId,Model model) {
			Food food = foodService.getById(foodId);
			
			boolean flag = foodService.deleteFood(food);
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
				boolean flag = false;
				if(foodType!=null) {
					flag = foodTypeService.delete(foodType);	
				}
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
		public String findFoodType(int foodTypeId) {
			System.out.println(foodTypeId);
			boolean flag = foodTypeService.findById(foodTypeId);
			ResponseMessage msg = new ResponseMessage();
			if(flag) {
				msg.setStatus(O2OConstants.SUCCESS);	
			}else {
				msg.setStatus(O2OConstants.FAILURE);
			}
			return mapper.writeObjectAsString(msg);				
		}
		
		//更新某个食品
		@ResponseBody
		@RequestMapping(value="/food/update",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
		public String updateFood( int foodId,String foodName,double price,Model model) {
			Food food = foodService.getById(foodId);
			food.setFoodName(foodName);
			food.setPrice(price);
			System.out.println(foodId);
			System.out.println(foodName+"..."+price);
			
			boolean flag = foodService.updateFood(food);
			model.addAttribute("food",food);
			ResponseMessage msg = new ResponseMessage();
			if(flag) {
				msg.setStatus(O2OConstants.SUCCESS);	
			}else {
				msg.setStatus(O2OConstants.FAILURE);
			}
			return mapper.writeObjectAsString(msg);	
			
		}
		
		
		

}
