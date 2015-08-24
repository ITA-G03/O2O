package ita.o2o.controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ita.o2o.constants.O2OConstants;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
@Controller
@RequestMapping("/action/register")
public class RegisterActionController {

    @Autowired
    JSONMapper jsonMapper;

    @RequestMapping("")
    @ResponseBody
    public String registerAction(){
        ResponseMessage responseMessage=new ResponseMessage();
        responseMessage.setStatus(O2OConstants.SUCCESS);
        return jsonMapper.writeObjectAsString(responseMessage);
    }
}
