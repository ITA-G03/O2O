package ita.o2o.controller.restful;

import ita.o2o.entity.base.BusinessTag;
import ita.o2o.service.impl.BusinessTagServiceImpl;
import ita.o2o.util.mapper.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-27
 */
@Controller
@RequestMapping("/rest/tag")
public class BusinessTagRestController {
    @Autowired
    JSONMapper jsonMapper;

    @Autowired
    BusinessTagServiceImpl businessTagService;


    @RequestMapping("/all")
    @ResponseBody
    public String getAllTags(){
        List<BusinessTag> businessTagList=businessTagService.getAll();
        return jsonMapper.writeObjectAsString(businessTagList);
    }


}
