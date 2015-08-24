package ita.o2o.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mine")
public class MineViewController {

    @RequestMapping("")
    public String homeView(){
        return "mine";
    }

}
