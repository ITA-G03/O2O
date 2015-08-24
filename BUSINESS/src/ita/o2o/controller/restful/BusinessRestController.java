package ita.o2o.controller.restful;


import ita.o2o.entity.base.Business;
import ita.o2o.entity.extra.Status;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


public class BusinessRestController {

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


    /**
     * 改变对应商家的信息
     *
     * @param business
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/business/change")
    public Business changeBusinessInfo(@RequestBody Business business) {
        return business;
    }

    /**
     * 获得对应商家的信息
     *
     * @param businessId
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/Business/{businessId}")
    public Business getBusinessInfo(@PathVariable Integer businessId) {
        System.out.printf(businessId.toString());
        Business business = new Business();
        business.setBusinessId(1);
        business.setRealName("奥尔良煎饼");
        Status status = new Status();
        status.setStatusId(1);
        status.setStatusName("申请");
        business.setStatus(status);
        return business;
    }

    /**
     * 审核商家的申请
     *
     * @param businessId,statusId
     * @return Business
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/Business/audit/{businessId}")
    public Business auditBusinessApply(@PathVariable Integer businessId, @RequestParam(value = "status") Integer statusId) {
        Business business = new Business();
        business.setBusinessId(businessId);
        business.setRealName("奥尔良煎饼");
        Status status1 = new Status();
        status1.setStatusId(statusId);
        business.setStatus(status1);
        return null;
    }


}
