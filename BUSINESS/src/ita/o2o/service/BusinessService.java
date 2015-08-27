package ita.o2o.service;

import ita.o2o.dto.OrderDto;
import ita.o2o.entity.base.Business;
import ita.o2o.entity.base.BusinessTag;
import ita.o2o.entity.base.Order;
import ita.o2o.entity.base.User;
import ita.o2o.entity.location.Location;

import java.util.List;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
public interface BusinessService {
    int createBusiness(Business business);

    Business getByUser(User user);
//    boolean deleteBusiness(Business business);

    boolean updateBusiness(Business business);

    Business getById(int id);

    List<Business> getAll();
    List<Business> getAllByTag(BusinessTag businessTag);

    List<Business> getAllByLocation(Location currentLocation);

    List<OrderDto> getJmsMessageByBusinessId(int businessId, List<Order> orders);
}
