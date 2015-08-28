package ita.o2o.controller.action;

import ita.o2o.constants.O2OConstants;
import ita.o2o.controller.BaseController;
import ita.o2o.entity.base.Order;
import ita.o2o.service.impl.FoodServiceImpl;
import ita.o2o.service.impl.OrderServiceImpl;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jason Cui
 * @version 2015-08-28
 */
@Controller
@RequestMapping("/action/order")
public class OrderActionController extends BaseController{

    @Autowired
    JSONMapper jsonMapper;

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    FoodServiceImpl foodService;

    @RequestMapping(value = "/comment/create",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String updateComment(int orderId,String comment,int rating){
        Order order=orderService.getOrderById(orderId);
        int updateResult=orderService.updateOrderRating(order, rating);
        ResponseMessage responseMessage=new ResponseMessage();
        switch (updateResult){
            case O2OConstants.DEFAULT_FAILURE_CODE:
                responseMessage.setStatus(O2OConstants.FAILURE);
                break;
            default:
                responseMessage.setStatus(O2OConstants.SUCCESS);
                break;
        }
        return jsonMapper.writeObjectAsString(responseMessage);
    }
}
