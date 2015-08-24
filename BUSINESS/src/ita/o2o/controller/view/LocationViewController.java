package ita.o2o.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ita.o2o.controller.BaseController;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
@Controller
@RequestMapping("/location")
public class LocationViewController extends BaseController{
    @RequestMapping("")
    public String locationView(){
        return "location";
    }
}
