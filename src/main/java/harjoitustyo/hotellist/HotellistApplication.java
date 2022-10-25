package harjoitustyo.hotellist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.hotellist.domain.AppUser;
import harjoitustyo.hotellist.domain.AppUserRepository;
import harjoitustyo.hotellist.domain.Hotel;
import harjoitustyo.hotellist.domain.HotelRepository;
import harjoitustyo.hotellist.domain.Review;
import harjoitustyo.hotellist.domain.ReviewRepository;



@SpringBootApplication
public class HotellistApplication {
	private static final Logger log = LoggerFactory.getLogger(HotellistApplication.class);
	
	@Autowired
	HotelRepository hrepository;

	@Autowired
	HotelRepository rrepository;
	
	@Autowired
	AppUserRepository userrepository;

	public static void main(String[] args) {
		SpringApplication.run(HotellistApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner hotellistdemo(HotelRepository hrepository, ReviewRepository rrepository, AppUserRepository userrepository) {
		return (args)->{
			log.info("Save reviews");
			rrepository.save(new Review ("1 star"));
			rrepository.save(new Review ("2 stars"));
			rrepository.save(new Review ("3 stars"));
			rrepository.save(new Review ("4 stars"));
			rrepository.save(new Review ("5 stars"));
			
			log.info("save hotels");
			hrepository.save(new Hotel("Radisson Blu Royal", "Runeberginkatu 5", "Superbreakfast buffet", 23.00, rrepository.findByStars("4 stars").get(0)));
			hrepository.save(new Hotel("Scandic Grand Central", "Vilhonkatu 13", "Laaja buffet jossa paljon tuotteita", 19.50,rrepository.findByStars("4 stars").get(0)));
			hrepository.save(new Hotel("Sokos Hotel Vaakuna", "Asema-aukio 2", "Buffet ", 19.90, rrepository.findByStars("3 stars").get(0)));
			
			//AppUsers
			AppUser user1 = new AppUser (null, "Anna","Annanen", "USER", "user", "$2a$10$/hwk6WkXnL7XrzElgLvAyuMfD1yxhfm.U7sKRRMmx/E94gROWa5Ie");
			AppUser user2 = new AppUser (null, "Maija","Maijanen", "ADMIN", "admin", "$2a$10$idxlI4y0S6g2PtXzh3rSCeOssFjGQJri7LOJbPUqs.WTploe1r7n2");
			userrepository.save(user1);
			userrepository.save(user2);
			
			log.info("get all hotels");
			for (Hotel hotel : hrepository.findAll()) {
				log.info(hotel.toString());
			}
		};
	}
}
