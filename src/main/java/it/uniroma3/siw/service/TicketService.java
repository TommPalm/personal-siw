package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import it.uniroma3.siw.repository.*;
import it.uniroma3.siw.model.*;

@Service
public class TicketService {

	private final TicketRepository repo;

	public TicketService(TicketRepository repo) {
		this.repo = repo;
	}
	
	@Transactional
	public Optional<Ticket> findById(Long id){
		return repo.findById(id);
	}
	@Transactional
	public List<Ticket> findAll(){
		return repo.findAll();
	}
	@Transactional
	public Ticket save(Ticket ticket) {
		ticket.setState(Stato.WIP);
		return repo.save(ticket);
	}
	@Transactional
	public List<Ticket> findByAutoOrderByCost(Auto auto){
		return repo.findByAutoOrderByCost(auto);
	}
	@Transactional
	public List<Ticket> findWip(){
		return repo.findByState(Stato.WIP);
	}
}
