package harjoitustyo.hotellist.web;


import javax.validation.Valid;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping(value = {"/main", "/"})
	public String showFirstPage() {
		//Log.info("Going to main page");
		return "mainPage";
	}
		
    @GetMapping(value= {"/", "/hotellist"})
    public String hotelList(Model model) {	
        model.addAttribute("hotels", hrepository.findAll());
        return "hotellist";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
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
    
	@PostMapping("save")
	public String saveHotel(@Valid Hotel hotel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("reviews", rrepository.findAll());
			System.out.println("Error happened");
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
