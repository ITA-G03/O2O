package ita.o2o.controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.Food;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;

@Controller
@RequestMapping("/action")
public class FoodActionController extends BaseController{
	
	@Autowired
	private JSONMapper mapper;
	//添加一个食品
		@ResponseBody
		@RequestMapping(value="food/create",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
		public String addFood(Model model) {
			Food food = new Food();
			model.addAttribute("food", food);
			ResponseMessage message = new ResponseMessage();
			message.setStatus("success");
			return mapper.writeObjectAsString(message);	
		}
		
		//删除某个食品
		@ResponseBody
		@RequestMapping(value="/food/delete",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
		public String deleteFood(Model model) {
			
			
			return "delete";
		}
		

}
