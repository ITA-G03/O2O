package ita.o2o.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



public class PageFowardController {
	
	@RequestMapping("/login")
	public String login1(){
		return "login";
	}
	@RequestMapping("/login/login")
	public String login(){
		return "login/login";
	}
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/business")
	public String business(){
		return "business";
	}
	
	@RequestMapping("/store")
	public String store(){
		return "store";
	}
	
	@RequestMapping("/customer")
	public String customer(){
		return "customer";
	}
	
	@RequestMapping("/setting")
	public String setting(){
		return "setting";
	}
}
