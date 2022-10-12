package harjoitustyo.hotellist.domain;

import java.util.List;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface HotelRepository extends CrudRepository<Hotel, Long>{

	List<Hotel> findByhotelName(String hotelName);
	
	//List<Hotel> findByReview(String stars);

}
