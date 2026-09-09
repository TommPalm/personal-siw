package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw.dto.*;
import java.util.*;
import it.uniroma3.siw.repository.*;
import it.uniroma3.siw.model.*;

@Service
public class TicketService {

	private final TicketRepository repo;
	private final AutomobileRepository autoRepo;

	public TicketService(TicketRepository repo, AutomobileRepository autoRepo) {
		this.repo = repo;
		this.autoRepo = autoRepo;
	}
	
	@Transactional
	public Ticket findById(Long id){
		return repo.findById(id).orElse(null);
	}
	@Transactional
	public List<Ticket> findAll(){
		return repo.findAll();
	}
	@Transactional
	public Ticket save(Ticket ticket) {
		if(ticket.getState()!="WIP" || ticket.getState()!="COMPLETED")
			ticket.setState("WIP");
		return repo.save(ticket);
	}
	@Transactional
	public void delete(Long id) {
		repo.findById(id).ifPresent(repo::delete);
	}
	@Transactional
	public List<Ticket> findByAutoOrderByCost(Automobile car){
		return repo.findByCarOrderByCost(car);
	}
	@Transactional
	public List<Ticket> findWip(){
		return repo.findByState("WIP");
	}
	@Transactional
	public List<Ticket> findCompleted(){
		return repo.findByState("COMPLETED");
	}
	
	
	
	
	
	public TicketsPageDTO getTicketsForCar(Long id) {

        Automobile car = autoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        List<TicketDTO> tickets = car.getTickets()
                .stream()
                .map(TicketDTO::new)
                .toList();

        return new TicketsPageDTO(
                new CarDTO(car),
                tickets
        );
    }
}
