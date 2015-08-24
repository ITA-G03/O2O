package ita.o2o.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/success")
public class SuccessViewController {

    @RequestMapping("")
    public String homeView(){
        return "success";
    }

}
