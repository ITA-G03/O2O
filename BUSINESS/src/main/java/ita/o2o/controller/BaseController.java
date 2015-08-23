package ita.o2o.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
@RequestMapping("/")
public class BaseController {

    @RequestMapping("")
    public String loginView(){
        return "login";
    }
}
