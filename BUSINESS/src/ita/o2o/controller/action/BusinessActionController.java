package ita.o2o.controller.action;

import ita.o2o.service.impl.BusinessServiceImpl;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/business", produces = "application/json;charset=utf-8")
public class BusinessActionController {
    @Autowired
    JSONMapper jsonMapper;

    @Autowired
    BusinessServiceImpl businessService;


    //regist....

    //update...


}
