package ita.o2o.entity.base;

import ita.o2o.entity.extra.FoodType;

import javax.persistence.*;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
@Entity
@Table(name = "FOOD")
public class Food {

    @Id
    @SequenceGenerator(sequenceName="SEQ_FOOD",name="foodSequence",allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="foodSequence")
    @Column(name="FOOD_ID",nullable = false)
    private int foodId;

    @Basic
    @Column(name="FOOD_NAME",nullable = false)
    private String foodName;

    @OneToOne
    @JoinColumn(name="FOOD_TYPE_ID")
    private FoodType foodType;


    @Basic
    @Column(name="FOOD_PICTURE_ID")
    private int foodPictureId;

    @Basic
    @Column(name="PRICE",nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name="BUSINESS_ID",nullable = false)
    private Business owner;

    @Basic
    @Column(name="AVG_RATING")//原谅这里使用了缩写
    private double averageRating;

    @Basic
    @Column(name="SALES_VOLUME")
    private double salesVolume;


    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public int getFoodPictureId() {
        return foodPictureId;
    }

    public void setFoodPictureId(int foodPictureId) {
        this.foodPictureId = foodPictureId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Business getOwner() {
        return owner;
    }

    public void setOwner(Business owner) {
        this.owner = owner;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(double salesVolume) {
        this.salesVolume = salesVolume;
    }
}
