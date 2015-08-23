package ita.o2o.entity.base;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
public class Food {
    private int foodId;
    private String foodName;
    private int foodPictureId;
    private double price;
    private double averageRating;
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
