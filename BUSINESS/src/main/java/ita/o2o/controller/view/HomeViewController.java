package ita.o2o.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
@Controller
@RequestMapping("/home")
public class HomeViewController {

    @RequestMapping("")
    public String homeView(){
        return "home";
    }



}
