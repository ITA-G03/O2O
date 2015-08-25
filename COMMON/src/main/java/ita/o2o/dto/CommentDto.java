package ita.o2o.dto;

/**
 * for testing..
 * @author YUKE
 *
 */
public class CommentDto {

	private int id;
	
	private double rating;
	
	private String body;
	
	private String date;
	
	public CommentDto(){}
	
	public CommentDto(int id, double rating, String body, String date){
		this.id = id;
		this.rating = rating;
		this.body = body;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
