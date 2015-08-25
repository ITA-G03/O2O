package ita.o2o.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZHANGJA4 on 8/25/2015.
 */
@Controller
@RequestMapping("/business")
public class BusinessViewController {

    @RequestMapping("/index")
    public String indexPage() {
        return "business-index";
    }

    @RequestMapping("/order")
    public String orderPage() {
        return "business-order";
    }

    @RequestMapping("/change-info")
    public String changeInfoPage() {
        return "business-change-info";
    }
}
