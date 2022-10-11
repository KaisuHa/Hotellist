package harjoitustyo.hotellist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
//import javax.validation.constraints.Size;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	//@Size(min = 1, message = "Please enter")
	private String hotelName, address, description;
	
	@Min(value = 5, message ="Price is needed")
	//@Max(value = 100, message = "Check value")
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "reviewid")
	private Review review;
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(String hotelName, String address, String description, double price, Review review) {
		super();
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.price = price;
		this.review = review;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
	
	
}
