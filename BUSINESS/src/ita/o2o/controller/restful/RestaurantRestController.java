package ita.o2o.controller.restful;

import ita.o2o.dto.BusinessDto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="rest/restaurant")
public class RestaurantRestController {

	public List<BusinessDto> init(){
		List<BusinessDto> bs = new ArrayList<BusinessDto>();
		BusinessDto b = new BusinessDto(1,"images/res.jpg","炸Tomcat",4.3,43,20,"30");
		BusinessDto b1 = new BusinessDto(1,"images/res1.jpg","Tomcat汉堡",4.3,43,20,"30");
		BusinessDto b2 = new BusinessDto(1,"images/res2.jpg","Tomcat肉",4.3,43,20,"30");
		BusinessDto b3 = new BusinessDto(1,"images/res3.jpg","沙县Tomcat",4.3,43,20,"30");
		BusinessDto b4 = new BusinessDto(1,"images/res4.jpg","Tomcat煲",4.3,43,20,"30");
		BusinessDto b5 = new BusinessDto(1,"images/res.jpg","炸Tomcat",4.3,43,20,"30");
		BusinessDto b6 = new BusinessDto(1,"images/res1.jpg","Tomcat汉堡",4.3,43,20,"30");
		BusinessDto b7 = new BusinessDto(1,"images/res2.jpg","Tomcat肉",4.3,43,20,"30");
		BusinessDto b8 = new BusinessDto(1,"images/res3.jpg","沙县Tomcat",4.3,43,20,"30");
		BusinessDto b9 = new BusinessDto(1,"images/res4.jpg","Tomcat煲",4.3,43,20,"30");
		bs.add(b);
		bs.add(b1);
		bs.add(b2);
		bs.add(b3);
		bs.add(b4);
		bs.add(b5);
		bs.add(b6);
		bs.add(b7);
		bs.add(b8);
		bs.add(b9);
		return bs;
	}
	
	@ResponseBody
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public List<BusinessDto> showRestaurantList(){
		System.out.println(this.init().toString());
		return this.init();
	}
	
	@ResponseBody
	@RequestMapping(value="/list/{storeName}", method = RequestMethod.PUT)
	public List<BusinessDto> searchRestaurant(@PathVariable String storeName){
		System.out.println(storeName);
		return null;
	}
	
	@RequestMapping(value="/list/hot", method = RequestMethod.GET)
	public List<BusinessDto> showHotRestaurant(){
		return null;
	}
	
}
