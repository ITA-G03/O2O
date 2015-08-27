package ita.o2o.controller.restful;

import ita.o2o.constants.O2OConstants;
import ita.o2o.dto.BusinessDto;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.location.Location;
import ita.o2o.service.RestaurantService;
import ita.o2o.service.impl.BusinessServiceImpl;
import ita.o2o.service.impl.FoodServiceImpl;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value="rest/restaurant",produces = "application/json; charset=utf-8")
public class RestaurantRestController {

	@Autowired
	JSONMapper jsonMapper;

	@Autowired
	RestaurantService restaurantService;

    @Autowired
    BusinessServiceImpl businessService;

    @Autowired
    FoodServiceImpl foodService;

	
	@ResponseBody
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String showRestaurantList(HttpServletRequest request){
        Location currentLocation=(Location)(request.getSession().getAttribute("location"));
        List<Business> businessList;
        if(currentLocation==null){
            businessList=businessService.getAll();
        }
        else{
            businessList= businessService.getAllByLocation(currentLocation);
        }

        List<BusinessDto> businessDtoList=new ArrayList<>();
        for(Business business:businessList){
            BusinessDto businessDto=foodService.getAvgRatingAndSalesVolumeByBusinessId(business.getBusinessId());
            businessDto.setId(business.getBusinessId());
            businessDto.setName(business.getRealName());
            businessDto.setLogoId(business.getLogoId());
            businessDto.setPrice(business.getSendPrice());
            businessDto.setTime(O2OConstants.BUSINESS_DELIVERY_TIME);
            businessDtoList.add(businessDto);
        }

        return jsonMapper.writeObjectAsString(businessDtoList);

        //return jsonMapper.writeObjectAsString(restaurantService.getRestaurantList());
	}
	
	@ResponseBody
	@RequestMapping(value="/list/{storeName}", method = RequestMethod.GET)
	public String searchRestaurant(@PathVariable String storeName){
		return jsonMapper.writeObjectAsString(restaurantService.getRestaurantListByName(storeName));
	}

	@ResponseBody
	@RequestMapping(value="/list/hot", method = RequestMethod.GET)
	public String showHotRestaurant(){
		return jsonMapper.writeObjectAsString(restaurantService.getHotRestaurantList());
	}

	@ResponseBody
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String showDetail(HttpSession session){
		BusinessDto businessDto = (BusinessDto)session.getAttribute("currentRestaurant");
		if(null != businessDto){
			return jsonMapper.writeObjectAsString(restaurantService.getRestaurantDetail(businessDto.getId()));
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value="/list/comment", method = RequestMethod.GET)
	public String showComment(HttpSession session){
		BusinessDto businessDto = (BusinessDto)session.getAttribute("currentRestaurant");
		if(null != businessDto){
			return jsonMapper.writeObjectAsString(restaurantService.getRestaurantComment(businessDto.getId()));
		}
		return null;
	}


}
