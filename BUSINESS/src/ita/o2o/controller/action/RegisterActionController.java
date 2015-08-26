package ita.o2o.controller.action;

import ita.o2o.entity.base.User;
import ita.o2o.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ita.o2o.constants.O2OConstants;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;

import javax.servlet.http.HttpSession;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
@Controller
@RequestMapping(value = "/action/register", produces = "application/json; charset=utf-8")
public class RegisterActionController {

    @Autowired
    JSONMapper jsonMapper;

    @Autowired
    CustomerServiceImpl customerService;

    @RequestMapping("")
    @ResponseBody
    public String registerAction(@RequestParam String tel, @RequestParam String password, @RequestParam String confirm, HttpSession session) {
        ResponseMessage responseMessage = new ResponseMessage();
        if (password.equals(confirm)) {
            
            User user = new User();
            user.setTel(tel);
            user.setEncryptedPassword(password);
            session.setAttribute("user", user);

            System.out.println("Service注册用户啦");
            int newCustomerId=customerService.registerCustomer(user);
            System.out.println("注册后的用户ID是:"+newCustomerId);
            responseMessage.setStatus(O2OConstants.SUCCESS);

        } else {
            responseMessage.setStatus(O2OConstants.FAILURE);
            responseMessage.getBody().put("errMsg", "两次输入的密码不匹配");
        }

        return jsonMapper.writeObjectAsString(responseMessage);
    }
}
