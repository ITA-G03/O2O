package ita.o2o.controller.restful;

import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.Order;
import ita.o2o.entity.base.User;
import ita.o2o.service.impl.OrderServiceImpl;
import ita.o2o.service.impl.UserServiceImpl;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 显示Customer所有订单的restController
 * @author Jason Cui
 * @version 2015-08-27
 */

@Controller
@RequestMapping("/rest/mine/order")
public class MineOrderRestController extends BaseController{

    @Autowired
    JSONMapper jsonMapper;

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    UserServiceImpl userService;


    @RequestMapping("/all")
    @ResponseBody
    public String getCustomerAllOrderList(HttpServletRequest request){
        User currentUser=(User)request.getSession().getAttribute("user");
        System.out.println("当前UserId:"+currentUser.getUserId());
        List<Order> orderList=orderService.getAllByCustomerId(currentUser.getUserId());
        return jsonMapper.writeObjectAsString(orderList);
    }


}
