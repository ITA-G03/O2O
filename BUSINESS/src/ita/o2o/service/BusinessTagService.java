package ita.o2o.service;

import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.BusinessTag;

import java.util.List;

/**
 * @author Jason Cui
 * @version 2015-08-27
 */
public interface BusinessTagService {
    BusinessTag getById(int id);
    List<BusinessTag> getByBusiness(Business business);
    List<BusinessTag> getAll();
}
