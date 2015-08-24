package ita.o2o.controller.restful;

import ita.o2o.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
@Controller
@RequestMapping("/rest/user")
public class UserRestController extends BaseController {

    @RequestMapping("/info")
    @ResponseBody
    public String getUserInfo(){
        return "hi";
    }
}
