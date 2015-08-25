package ita.o2o.dto;

/**
 * for testing..
 * @author YUKE
 *
 */
public class FoodDto {

	private int id;
    
    private String name;
    
    private int foodPictureId;
    
    private double price;
    
    private double sales;
    
    private String tag;
    
    public FoodDto(){}
    
    public FoodDto(int id, String name, int foodPictureId, double price, double sales, String tag){
    	this.id = id;
    	this.name = name;
    	this.foodPictureId = foodPictureId;
    	this.price = price;
    	this.sales = sales;
    	this.tag = tag;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
    
    
}
