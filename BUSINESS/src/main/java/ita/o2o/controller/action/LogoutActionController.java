package ita.o2o.controller.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
@Controller
@RequestMapping("/action/logout")
public class LogoutActionController {

    @RequestMapping("")
    public String logoutAction(){

        return "redirect:/login";
    }
}
