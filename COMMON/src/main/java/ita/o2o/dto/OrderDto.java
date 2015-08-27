package ita.o2o.dto;

import ita.o2o.entity.base.User;

import java.util.List;

/**
 * Created by YUKE on 8/27/2015.
 */
public class OrderDto {

    private User user;

    private BusinessDto businessDto;

    private List<FoodDto> foodDtos;

    private String customerAddr;

    private String remark;

    public OrderDto(){}

    public String getCustomerAddr() {
        return customerAddr;
    }

    public void setCustomerAddr(String customerAddr) {
        this.customerAddr = customerAddr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BusinessDto getBusinessDto() {
        return businessDto;
    }

    public void setBusinessDto(BusinessDto businessDto) {
        this.businessDto = businessDto;
    }

    public List<FoodDto> getFoodDtos() {
        return foodDtos;
    }

    public void setFoodDtos(List<FoodDto> foodDtos) {
        this.foodDtos = foodDtos;
    }
}
