package ita.o2o.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parts")
public class PartsViewController {

    @RequestMapping("/index/nav")
    public String homeView(){
        return "ng-index-nav";
    }

}
