package ita.o2o.service;

import ita.o2o.entity.base.Business;

import java.util.List;

public interface BusinessService {
	
	List<Business> getAllApprovingBusiness();
	
	boolean acceptBusiness(Business business);
}	
