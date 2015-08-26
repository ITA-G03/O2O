package ita.o2o.controller.action;

import ita.o2o.constants.O2OConstants;
import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.User;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


/**
 * @author Aquariuslt
 * @version 15-08-23
 */
@Controller
@RequestMapping(value = "/action/login", produces = "application/json; charset=utf-8")
public class LoginActionController extends BaseController {
    @Autowired
    JSONMapper jsonMapper;

    @RequestMapping("")
    @ResponseBody
    public String loginAction(@RequestParam String tel, @RequestParam String password, HttpSession session) {
        ResponseMessage responseMessage = new ResponseMessage();
        System.out.println(password);
        if (tel.equals("13333333333") && password.equals("123")) {
            responseMessage.setStatus(O2OConstants.SUCCESS);
            User user = new User();
            user.setTel(tel);
            user.setEncryptedPassword(password);
            session.setAttribute("user", user);
        } else {
            responseMessage.setStatus(O2OConstants.FAILURE);
            responseMessage.getBody().put("errMsg", "用户名与密码不匹配");
        }
        return jsonMapper.writeObjectAsString(responseMessage);
    }
}
