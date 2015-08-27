package ita.o2o.dao;

import ita.o2o.entity.base.Business;

import java.util.List;

public interface BusinessDao {
	List<Business> getAllApprovingBusiness();
	
	boolean update(Business business);
	
	Business get(int id);

}
