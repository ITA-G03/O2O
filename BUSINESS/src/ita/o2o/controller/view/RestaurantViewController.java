package ita.o2o.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/restaurant")
public class RestaurantViewController {

    @RequestMapping(value = "/{businessId}", method = RequestMethod.GET)
    public String getCurrentRestaurant(@PathVariable int businessId, HttpSession session){
        session.setAttribute("currentRestaurant", businessId);
        return "restaurant";
    }
}
