package harjoitustyo.hotellist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import harjoitustyo.hotellist.domain.Hotel;
import harjoitustyo.hotellist.domain.HotelRepository;
import harjoitustyo.hotellist.domain.Review;


@DataJpaTest
public class HotelRepositoryTests {
	
	@Autowired
	HotelRepository hRepository;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void findByHotelnameShouldReturnHotel() {
		//Hotel hotel = hRepository.findByhotelName("Radisson Blu Royal").get(1).getAddress();
		//List<Hotel> hotels = hRepository.findByhotelName("Radisson Blu Royal");
		
		//assertEquals(hotels.get(1).getAddress(),("Runeberginkatu 5"));
		
		Review review = hRepository.findById((long) 1).get().getReview();
		System.out.println("Haku id 1 " + review);
		assertEquals(review.getStars(), "4 stars");
	}

	
	@Test
	public void createNewHotel() {
		Hotel hotel = new Hotel ("Hotel U14", "Unioninkatu 5", "Breakfast buffet with desserts", 29.00, new Review("5 stars"));
		hRepository.save(hotel);
		assertNotNull(hotel.getId());
	}

}
