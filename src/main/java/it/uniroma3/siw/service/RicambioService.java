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
	public boolean existsByNome(String nome) {
	    return repo.existsByNome(nome);
	}
	@Transactional
	public boolean existsByProducer(String producer) {
	    return repo.existsByProducer(producer);
	}

	
	@Transactional
	public Ricambio findById(Long id) {
		return repo.findById(id).orElse(null);
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
	public void delete(Long id) {
		repo.findById(id).ifPresent(repo::delete);
	}
	@Transactional
	public List<Ricambio> findByNome(String nome){
		return repo.findByNome(nome);
	}
	@Transactional
	public List<Ricambio> findByProducer(String proucer){
		return repo.findByProducerOrderByNome(proucer);
	}
	@Transactional
	public Ricambio findByNomeAndProducer(String nome, String producer) {
		return repo.findByNomeAndProducer(nome, producer);
	}
}
