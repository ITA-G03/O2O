package ita.o2o.controller.action;

import ita.o2o.constants.O2OConstants;
import ita.o2o.entity.admin.Admin;
import ita.o2o.entity.admin.Configuration;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.User;
import ita.o2o.service.impl.BusinessServiceImpl;
import ita.o2o.service.impl.ConfigServiceImpl;
import ita.o2o.service.impl.LoginServiceImpl;
import ita.o2o.service.impl.UserServiceImpl;
import ita.o2o.util.bean.ResponseMessage;
import ita.o2o.util.mapper.JSONMapper;
import ita.o2o.vo.BusinessVo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {
	@Autowired
	LoginServiceImpl loginService;

	@Autowired
	ConfigServiceImpl configService;

	@Autowired
	UserServiceImpl userService;

	@Autowired
	JSONMapper jsonMapper;

	@Autowired
	BusinessServiceImpl businessService;

	ResponseMessage responseMessage = new ResponseMessage();

	@RequestMapping(value = "/adminlogin", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String adminlogin(Admin a) {
		boolean flag = loginService.login(a);
		responseMessage.setStatus(flag ? O2OConstants.SUCCESS
				: O2OConstants.FAILURE);
		return jsonMapper.writeObjectAsString(responseMessage);
	}

	@RequestMapping(value = "/updateValue", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String updateValue(Configuration config) {
		boolean flag = configService.update(config);
		responseMessage.setStatus(flag ? O2OConstants.SUCCESS
				: O2OConstants.FAILURE);
		return jsonMapper.writeObjectAsString(responseMessage);
	}

	@RequestMapping(value = "/queryAllValue", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String queryAllValue() {
		List<User> userList = userService.query();
		String message = jsonMapper.writeObjectAsDataString(userList);
		return message;

	}

	@RequestMapping(value = "/resetPassword", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String resetPassword(String tel) {
		boolean flag = userService.update(tel);
		responseMessage.setStatus(flag ? O2OConstants.SUCCESS
				: O2OConstants.FAILURE);
		return jsonMapper.writeObjectAsString(responseMessage);

	}

	@RequestMapping(value = "/allApprovingBusinessDetail", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String allApprovingBusinessDetail() {
		List<Business> businessList = businessService.getAllApprovingBusiness();
		List<BusinessVo> voList=new ArrayList<BusinessVo>();
		for(Business business:businessList){
			voList.add(new BusinessVo(business));
		}
		String message = jsonMapper.writeObjectAsDataString(voList);
		return message;
		
	}

	@RequestMapping(value = "/approvingBusiness", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String approvingBusiness() {
		List<Business> businessList = businessService.getAllApprovingBusiness();
		String message = jsonMapper.writeObjectAsDataString(businessList.size());
		return message;

	}
	
	
	@RequestMapping(value = "/updateAcceptBusiness", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String updateAcceptBusiness(int businessId) {
		Business business=new Business();
		business.setBusinessId(businessId);
		boolean flag = businessService.acceptBusiness(business);
		responseMessage.setStatus(flag ? O2OConstants.SUCCESS
				: O2OConstants.FAILURE);
		return jsonMapper.writeObjectAsString(responseMessage);

	}

}