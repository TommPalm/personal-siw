package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import it.uniroma3.siw.model.*;
import it.uniroma3.siw.repository.UtenteRepository;

@Service
public class UtenteService {

	private final UtenteRepository repo;

	public UtenteService(UtenteRepository repo) {
		this.repo = repo;
	}
	
	@Transactional
	public List<Utente> findAll(){
		return repo.findAll();
	}
	
	@Transactional 
	public Utente findById(Long id){
		return repo.findById(id).orElse(null);
	}
	@Transactional
	public Utente save(Utente user) {
		return repo.save(user);
	}
	@Transactional
	public Utente findByNome(String name){
		return repo.findByNome(name);
	}
	@Transactional
	public List<Utente> findBySurname(String surname){
		return repo.findBySurname(surname);
	}
	@Transactional
	public List<Utente> findByCellphone(int cell){
		return repo.findByCellphone(cell);
	}
}
