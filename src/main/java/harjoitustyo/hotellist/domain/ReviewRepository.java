package harjoitustyo.hotellist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface ReviewRepository extends CrudRepository<Review, Long> {
	
	List<Review> findByStars(String stars);

}
