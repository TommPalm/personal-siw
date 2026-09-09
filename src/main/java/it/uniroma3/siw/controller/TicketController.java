package it.uniroma3.siw.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.*;
import it.uniroma3.siw.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class TicketController {

	private final AutomobileService automobileService;
	private final TicketService ticketService;
	private final AutomobileService autoService;
	
	public TicketController(AutomobileService automobileService, TicketService ticketService,AutomobileService autoService) {
		this.automobileService = automobileService;
		this.ticketService = ticketService;
		this.autoService = autoService;
	}

	@GetMapping("/amm/ticket")
	public String ticket(Model model) {
		model.addAttribute("ticket", new Ticket());
		model.addAttribute("tiks", ticketService.findAll());
		model.addAttribute("cars", autoService.findAll());
		return "amm/ticket";
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
	@GetMapping("/cars/{id}/tickets")
	public String tickets(@PathVariable Long id, Model model) {

	    Automobile car = automobileService.findById(id);
	    model.addAttribute("car", car);
	    model.addAttribute("tickets", car.getTickets());

	    return "extickets";
	}
*/	
	
	@GetMapping("/cars/{id}/tickets")
	public String tickets(
	        @PathVariable Long id,
	        Model model) {

	    model.addAttribute("carId", id);

	    return "tickets";
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@PostMapping("/ticket")
	public String ticketMod(Model model,
            @Valid @ModelAttribute("ticket") Ticket ticket,
            BindingResult ticketBindingResult,
            @RequestParam("carId") Long carId,
            HttpServletRequest request) throws ServletException {
		
		if (ticketBindingResult.hasErrors()) {
			return "amm/ticket";
	    }
		Automobile car = automobileService.findById(carId);

	    if (car == null) {
	        model.addAttribute("error", "L'auto selezionata non esiste.");
	        return "amm/ticket";
	    }

	    ticket.setCar(car);
		ticketService.save(ticket);
		
		return "redirect:amm/ticket";
	}
	
	@PostMapping("/ticketRem")
	public String ticketRemove(Model model,@RequestParam("ticketId") Long ticketId) {

	    Ticket ticket = ticketService.findById(ticketId);

	    if (ticket == null) {
	    	model.addAttribute("error", "Il ticket selezionato non esiste.");
	        return "amm/ticket";
	    }
	    
	    ticketService.delete(ticketId);

	    return "redirect:amm/ticket";
	}


}
