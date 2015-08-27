package ita.o2o.service.impl;

import ita.o2o.dao.impl.BusinessDaoImpl;
import ita.o2o.dao.impl.StatusDaoImpl;
import ita.o2o.entity.base.Business;
import ita.o2o.service.BusinessService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("businessService")
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	BusinessDaoImpl businessDao;
	
	@Autowired
	StatusDaoImpl statusDao;

	@Override
	public List<Business> getAllApprovingBusiness() {
		
		return businessDao.getAllApprovingBusiness();
	}

	@Override
	public boolean acceptBusiness(Business business) {
//		business.setStatus(statusDao.getById(O2OConstants.STATUS_ACCEPTED));
//		boolean flag=businessDao.update(business);
//		return flag;
		return true;
	}
	

}
