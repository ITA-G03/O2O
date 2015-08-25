package ita.o2o.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZHANGJA4 on 8/25/2015.
 */
@Controller
@RequestMapping("/business")
public class BusinessViewController {

    @RequestMapping("/Index")
    public String homeView() {
        return "businessIndex";
    }
}
