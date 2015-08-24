package ita.o2o.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurant")
public class RestaurantViewController {

    @RequestMapping("")
    public String homeView(){
        return "restaurant";
    }

}
