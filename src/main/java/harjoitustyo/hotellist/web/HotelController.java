package harjoitustyo.hotellist.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import harjoitustyo.hotellist.domain.Hotel;
import harjoitustyo.hotellist.domain.HotelRepository;
import harjoitustyo.hotellist.domain.ReviewRepository;


@Controller
public class HotelController {
	
	@Autowired
	private HotelRepository hrepository; 
	
	@Autowired
	private ReviewRepository rrepository;
		
    @GetMapping(value= {"/", "/hotellist"})
    public String hotelList(Model model) {	
        model.addAttribute("hotels", hrepository.findAll());
        return "hotellist";
    }
    
    @GetMapping("/edit/{id}")
	public String editHotel(@PathVariable("id") Long hotelId, Model model) {
		model.addAttribute("hotel", hrepository.findById(hotelId));
		model.addAttribute("reviews", rrepository.findAll());
		return "edithotel";
    }
  
    @RequestMapping(value = "/add")
    public String addHotel(Model model){
    	model.addAttribute("hotel", new Hotel());
    	model.addAttribute("reviews", rrepository.findAll());
        return "addhotel";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveHotel(@Valid Hotel hotel, BindingResult bindingResult){
    	if (bindingResult.hasErrors()) {
    		System.out.println("Error has happened");
    		return "addhotel";
    	}
        hrepository.save(hotel);
        return "redirect:hotellist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteHotel(@PathVariable("id") Long hotelId, Model model) {
    	hrepository.deleteById(hotelId);
        return "redirect:../hotellist";
    } 
}
