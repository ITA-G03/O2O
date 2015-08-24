package ita.o2o.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderViewController {

    @RequestMapping("")
    public String homeView(){
        return "order";
    }

}
