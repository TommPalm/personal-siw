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
	
	@Transactional(readOnly=true)
	public boolean existsByNome(String nome) {
	    return repo.existsByNome(nome);
	}
	@Transactional(readOnly=true)
	public boolean existsByProducer(String producer) {
	    return repo.existsByProducer(producer);
	}

	
	@Transactional(readOnly=true)
	public Ricambio findById(Long id) {
		return repo.findById(id).orElse(null);
	}
	@Transactional(readOnly=true)
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
	@Transactional(readOnly=true)
	public List<Ricambio> findByNome(String nome){
		return repo.findByNome(nome);
	}
	@Transactional(readOnly=true)
	public List<Ricambio> findByProducer(String proucer){
		return repo.findByProducerOrderByNome(proucer);
	}
	@Transactional(readOnly=true)
	public Ricambio findByNomeAndProducer(String nome, String producer) {
		return repo.findByNomeAndProducer(nome, producer);
	}
}
