package ita.o2o.controller.view;

import ita.o2o.entity.base.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/mine")
public class MineViewController {

    @RequestMapping("")
    public String homeView(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:login";
        } else {
            return "mine";
        }
    }

}
