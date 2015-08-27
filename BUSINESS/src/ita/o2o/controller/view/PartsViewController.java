package ita.o2o.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parts")
public class PartsViewController {

    @RequestMapping("/index/nav")
    public String indexNavView() {
        return "ng-index-nav";
    }

    @RequestMapping("/index/footer")
    public String indexFooterView() {
        return "ng-index-footer";
    }

    @RequestMapping("/main/nav")
    public String mainNavView() {
        return "ng-main-nav";
    }

    @RequestMapping("/main/footer")
    public String mainFooterView() {
        return "ng-main-footer";
    }
}
