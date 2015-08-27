package ita.o2o.service.impl;

import ita.o2o.constants.O2OConstants;
import ita.o2o.dao.impl.BusinessDaoImpl;
import ita.o2o.dao.impl.StatusDaoImpl;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.extra.Status;
import ita.o2o.service.BusinessService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("businessService")
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	BusinessDaoImpl businessDao;
	
	@Autowired
	StatusDaoImpl statusDao;

	@Override
	@Transactional
	public List<Business> getAllApprovingBusiness() {
		
		return businessDao.getAllApprovingBusiness();
	}

	@Override
	@Transactional
	public boolean acceptBusiness(Business business) {
		//business.setStatus(statusDao.getById(O2OConstants.STATUS_ACCEPTED));
		Status status=new Status();
		status.setStatusId(O2OConstants.STATUS_ACCEPTED);
		Business dbBusiness=this.businessDao.get(business.getBusinessId());
		dbBusiness.setStatus(status);
		boolean flag=businessDao.update(dbBusiness);
		return flag;
	}
	

}
