package ita.o2o.controller.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.Food;

@Controller
@RequestMapping("/action")
public class FoodActionController extends BaseController{
	
	//添加一个食品
		@ResponseBody
		@RequestMapping(value="business/create",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
		public String addFood(Model model) {
			Food food = new Food();
			model.addAttribute("food", food);
			
			
			return "success";	
		}

}
