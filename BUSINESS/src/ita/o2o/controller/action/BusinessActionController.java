package ita.o2o.controller.action;


import ita.o2o.entity.base.Business;
import ita.o2o.entity.extra.Status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BusinessActionController {

    /**
     * 用户提交申请成为商家
     *
     * @param business
     * @param card_photoFile
     * @param licenseFile
     * @param logoFile
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/business/apply")
    public Business applyForBussniess(@RequestBody Business business,
                                      @RequestParam(value = "card_photo") MultipartFile card_photoFile,
                                      @RequestParam(value = "license") MultipartFile licenseFile,
                                      @RequestParam(value = "logo") MultipartFile logoFile) {
        return business;
    }
}
