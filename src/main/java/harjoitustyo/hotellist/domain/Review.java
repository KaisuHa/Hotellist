package harjoitustyo.hotellist.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long reviewid;
	private String stars;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "review")
	private List<Hotel> hotels;

	public Review() {
		super();
		
	}
	
	
	public Review(String stars) {
		super();
		this.stars = stars;
	}




	public Long getReviewid() {
		return reviewid;
	}

	public void setReviewid(Long reviewid) {
		this.reviewid = reviewid;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}


	@Override
	public String toString() {
		return "Review [reviewid=" + reviewid + ", stars=" + stars + ", hotels=" + hotels + "]";
	}
	


}
