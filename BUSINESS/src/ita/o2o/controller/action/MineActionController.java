package ita.o2o.controller.action;

import ita.o2o.constants.O2OConstants;
import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.User;
import ita.o2o.service.impl.UserServiceImpl;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jason Cui
 * @version 2015-08-27
 */
@Controller
@RequestMapping("/action/mine")
public class MineActionController extends BaseController{

    @Autowired
    JSONMapper jsonMapper;

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/info/update",method = RequestMethod.POST)
    @ResponseBody
    public String updatePasswordAction(String oldPassword,String newPassword,HttpServletRequest request){
        User currentUser=(User)request.getSession().getAttribute("user");
        ResponseMessage responseMessage=new ResponseMessage();
        int updateResult=userService.updatePassword(currentUser.getUserId(),oldPassword,newPassword);
        switch (updateResult){
            case O2OConstants.USER_UPDATE_SUCCESS:
                responseMessage.setStatus(O2OConstants.SUCCESS);
                break;
            case O2OConstants.DEFAULT_FAILURE_CODE:
                responseMessage.setStatus(O2OConstants.FAILURE);
                responseMessage.getBody().put("errMsg", "Update Fail");
                break;
            case O2OConstants.USER_UPDATE_OLD_PASSWORD_WRONG:
                responseMessage.setStatus(O2OConstants.FAILURE);
                responseMessage.getBody().put("errMsg","Old Password Wrong");
                break;
        }
        return jsonMapper.writeObjectAsString(responseMessage);
    }

}
