package ita.o2o.controller.view;

import ita.o2o.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
@Controller
@RequestMapping("/user")
public class UserViewController extends BaseController{

    @RequestMapping("/profile")
    public String userProfileView(){
        return "";
    }
}
