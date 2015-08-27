package ita.o2o.controller.view;

import ita.o2o.dto.BusinessDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/restaurant")
public class RestaurantViewController {

    @RequestMapping(value = "/{businessId}/{storeName}", method = RequestMethod.GET)
    public String getCurrentRestaurant(@PathVariable int businessId, @PathVariable String storeName, HttpSession session){
        System.out.println(storeName);

        BusinessDto businessDto = new BusinessDto();
        businessDto.setId(businessId);
        businessDto.setName(storeName);

        session.setAttribute("currentRestaurant", businessDto);
        return "restaurant";
    }
}
