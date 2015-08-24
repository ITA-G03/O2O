package ita.o2o.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexViewController {

    @RequestMapping("")
    public String homeView(){
        return "index";
    }

}
