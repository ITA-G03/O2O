package ita.o2o.controller.view;

import ita.o2o.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
@Controller
@RequestMapping("/register")
public class RegisterViewController extends BaseController{

    @RequestMapping("")
    public String loginView(){
        return "register";
    }
}
