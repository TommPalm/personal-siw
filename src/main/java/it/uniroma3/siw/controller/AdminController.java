package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.service.*;

@Controller
public class AdminController {
	
	private final UtenteService utenteService;
	private final AutomobileService autoService;
	private final TicketService ticketService;
	private final RicambioService ricambioService;
	
	

	public AdminController(UtenteService utenteService, AutomobileService autoService, TicketService ticketService,
			RicambioService ricambioService) {
		this.utenteService = utenteService;
		this.autoService = autoService;
		this.ticketService = ticketService;
		this.ricambioService = ricambioService;
	}



	@GetMapping("/admin")
	public String admin(Model model) {
		
		model.addAttribute("users",utenteService.findAll());
		model.addAttribute("auto",autoService.findAll());
		model.addAttribute("tickets",ticketService.findAll());
		model.addAttribute("ricambi",ricambioService.findAll());
		
	    return "admin";
	}
	
}
