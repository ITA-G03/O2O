package ita.o2o.controller.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
@Controller
@RequestMapping("/action/logout")
public class LogoutActionController {

    @RequestMapping("")
    public String logoutAction(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
