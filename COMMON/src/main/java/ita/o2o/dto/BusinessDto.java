package ita.o2o.dto;

import java.util.List;

/**
 * for testing..
 * @author YUKE
 *
 */
public class BusinessDto {
	
	private int id;
	
	private String img;
	
	private String name;
	
	private double rating;
	
	private double sales;
	
	//起送
	private double price;
	
	private String time;
	
	private List<FoodDto> foodList;
	
	public BusinessDto(){}
	
	public BusinessDto(int id, String img, String name, double rating, double sales, double price, String time){
		this.id = id;
		this.img = img;
		this.name = name;
		this.rating = rating;
		this.sales = sales;
		this.time = time;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<FoodDto> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<FoodDto> foodList) {
		this.foodList = foodList;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
