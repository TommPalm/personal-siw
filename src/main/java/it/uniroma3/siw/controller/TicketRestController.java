package it.uniroma3.siw.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import it.uniroma3.siw.dto.*;
import it.uniroma3.siw.service.*;

@RestController
public class TicketRestController {

	private final TicketService ticketService;

	public TicketRestController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	
	@GetMapping("api/cars/{id}/tickets")
	public ResponseEntity<TicketsPageDTO> getTickets(
			@PathVariable Long id) {

		return ResponseEntity.ok(
				ticketService.getTicketsForCar(id)
				);
	}
	

}


