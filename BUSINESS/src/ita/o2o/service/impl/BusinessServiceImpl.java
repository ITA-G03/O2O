package ita.o2o.service.impl;


import ita.o2o.dao.impl.BusinessDaoImpl;
import ita.o2o.dao.impl.CityDaoImpl;
import ita.o2o.dao.impl.LocationDaoImpl;
import ita.o2o.dto.FoodDto;
import ita.o2o.dto.OrderDto;
import ita.o2o.entity.base.*;
import ita.o2o.entity.location.City;
import ita.o2o.entity.location.Location;
import ita.o2o.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WhiteSaber on 15/8/26.
 */
@Service("businessService")
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    BusinessDaoImpl businessDao;

    @Autowired
    CityDaoImpl cityDao;

    @Autowired
    LocationDaoImpl locationDao;


    @Override
    @Transactional
    public int createBusiness(Business business) {
        int createFlag = businessDao.create(business);
        System.out.println("Service Create Flag:" + createFlag);
        System.out.println("Id:" + business.getBusinessId());
        System.out.println("Name:" + business.getRealName());
        return createFlag;
    }

    @Override
    public Business getByUser(User user) {
        return businessDao.getByUser(user);
    }

    @Override
    @Transactional
    public boolean updateBusiness(Business business) {
        return businessDao.update(business);
    }

    @Override
    public Business getById(int id) {
        return businessDao.getById(id);
    }

    @Override
    public List<Business> getAll() {
        return businessDao.getAll();
    }

    @Override
    public List<Business> getAllByTag(BusinessTag businessTag) {
        List<Business> businessList= businessDao.getAllByTag(businessTag);
        for(Business business:businessList){
            business.getBusinessTags().clear();
        }
        return businessList;
    }

    @Override
    public List<Business> getAllByLocation(Location location) {
        City city=cityDao.getById(location.getCity().getCityId());
        List<Location> locationList=locationDao.getByCity(city);
        List<Business> businessList= businessDao.getAllByLocationList(locationList);


        for(Business business:businessList){
            business.getBusinessTags().clear();
        }
        return businessList;
    }

    @Override
    public List<OrderDto> getJmsMessageByBusinessId(int businessId, List<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for(Order order : orders){
            if(order.getBusiness().getBusinessId() == businessId){
                OrderDto orderDto = new OrderDto();
                orderDto.setUser(order.getCustomer());
                orderDto.setFoodDtos(foodDtoListConvert(order.getOrderItemList()));
                orderDto.setCustomerAddr(order.getAddress());
                orderDto.setRemark(order.getComments());
                orderDtos.add(orderDto);
            }
        }
        return orderDtos;
    }

    public List<FoodDto> foodDtoListConvert(List<OrderItem> orderItems){
        List<FoodDto> foodDtos = new ArrayList<>();
        for(OrderItem orderItem : orderItems){
            Food food = orderItem.getFood();
            FoodDto foodDto = new FoodDto();
            foodDto.setId(food.getFoodId());
            foodDto.setFoodPictureId(food.getFoodPictureId());
            foodDto.setName(food.getFoodName());
            foodDto.setPrice(food.getPrice());
            foodDto.setNum(orderItem.getCount());
            foodDtos.add(foodDto);
        }
        return foodDtos;
    }
}
