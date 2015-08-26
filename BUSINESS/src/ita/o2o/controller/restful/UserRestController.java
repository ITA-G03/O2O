package ita.o2o.controller.restful;

import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.User;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
@Controller
@RequestMapping("/rest/user")
public class UserRestController extends BaseController {

    @Autowired
    JSONMapper jsonMapper;

    @RequestMapping("/info")
    @ResponseBody
    public String getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return jsonMapper.writeObjectAsString(user);
        }
        return null;
    }
}
