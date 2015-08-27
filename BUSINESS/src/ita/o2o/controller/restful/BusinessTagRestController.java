package ita.o2o.controller.restful;

import ita.o2o.service.impl.BusinessTagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jason Cui
 * @version 2015-08-27
 */
@Controller
@RequestMapping("/rest/tag")
public class BusinessTagRestController {
    @Autowired
    BusinessTagServiceImpl businessTagService;


    @RequestMapping("/all")
    @ResponseBody
    public String getAllTags(){
        return "";
    }
}
