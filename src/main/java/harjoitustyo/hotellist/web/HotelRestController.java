package harjoitustyo.hotellist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import harjoitustyo.hotellist.domain.Hotel;
import harjoitustyo.hotellist.domain.HotelRepository;

@RestController
public class HotelRestController {
	
	@Autowired
	HotelRepository hotelRepository;
	
	//this is returning hotel listing
	@GetMapping("/hotels")
	public Iterable<Hotel> getHotels() {
		return hotelRepository.findAll();
	}
	
	//new hotel adding
	@PostMapping("hotels")
	Hotel newHotel(@RequestBody Hotel newHotel) {
		return hotelRepository.save(newHotel);
	}

	//editing hotels
	@PutMapping ("/hotels/{id}")
	Hotel editedHotel(@RequestBody Hotel editedHotel, @PathVariable Long id) {
		editedHotel.setId(id);
		return hotelRepository.save(editedHotel);
	}
	
	//deleting hotels
	@DeleteMapping("/hotels/{id}")
	public Iterable<Hotel> deleteHotel(@PathVariable Long id) {
		hotelRepository.deleteById(id);
		return hotelRepository.findAll();
	}

}
