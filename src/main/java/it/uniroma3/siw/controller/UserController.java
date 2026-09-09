package it.uniroma3.siw.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import it.uniroma3.siw.model.*;
import it.uniroma3.siw.service.*;


@Controller
public class UserController {

	private final CredenzialiService credenzialiService;
	private final AutomobileService automobileService;
	
	public UserController(CredenzialiService credenzialiService, AutomobileService automobileService) {
		this.automobileService = automobileService;
		this.credenzialiService = credenzialiService;
	}

	@GetMapping("/personal")
	public String cars(Model model, Authentication authentication) {

		String username = authentication.getName(); //trova l'username
		Credenziali cred = credenzialiService.findByUsername(username);
		Utente user = cred.getUser();

	    List<Automobile> cars = automobileService.findByOwner(user);

	   model.addAttribute("cars", cars);

	    return "personal";
	}


}
