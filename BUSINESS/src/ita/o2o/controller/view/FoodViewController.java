package ita.o2o.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ita.o2o.controller.BaseController;

@Controller
@RequestMapping("/food")
public class FoodViewController  extends BaseController{
	
	@RequestMapping("addfood")
	public String addFoodView() {
		
		return "newFood";
	}
	
	@RequestMapping("home")
	public String homeView() {
		
		return "index";
	}

}
