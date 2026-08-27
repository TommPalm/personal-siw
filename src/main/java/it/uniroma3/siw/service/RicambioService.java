package it.uniroma3.siw.service;

import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw.model.*;
import it.uniroma3.siw.repository.*;

@Service
public class RicambioService {

	private final RicambioRepository repo;

	public RicambioService(RicambioRepository repo) {
		this.repo = repo;
	}
	
	@Transactional
	public Optional<Ricambio> findById(Long id) {
		return repo.findById(id);
	}
	@Transactional
	public List<Ricambio> findAll(){
		return repo.findAll();
	}
	@Transactional
	public Ricambio save(Ricambio ric) {
		return repo.save(ric);
	}
	@Transactional
	public List<Ricambio> findByName(String name){
		return repo.findByName(name);
	}
	@Transactional
	public List<Ricambio> findByProducer(String proucer){
		return repo.findByProducerOrderByName(proucer);
	}
}
