package ita.o2o.controller.action;

import ita.o2o.constants.O2OConstants;
import ita.o2o.controller.BaseController;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
    public String loginAction(String tel, String password) {
        ResponseMessage responseMessage = new ResponseMessage();
        if (tel != null && password != null && tel.equals("18666147587") && password.equals("123")) {
            responseMessage.setStatus(O2OConstants.SUCCESS);
        } else {
            responseMessage.setStatus(O2OConstants.FAILURE);
            responseMessage.getBody().put("errMsg", "用户名与密码不匹配");
        }
        return jsonMapper.writeObjectAsString(responseMessage);
    }
}
