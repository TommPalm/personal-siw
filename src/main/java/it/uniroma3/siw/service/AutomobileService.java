package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import it.uniroma3.siw.repository.*;
import it.uniroma3.siw.model.*;

@Service
public class AutomobileService {

	private final AutomobileRepository repo;

	public AutomobileService(AutomobileRepository repo) {
		this.repo = repo;
	}
	
	@Transactional(readOnly=true)
	public List<Automobile> findAll(){
		return repo.findAll();
	}
	
	@Transactional(readOnly=true)
	public Automobile findById(Long id) {
	    if (id == null) {
	        return null;
	    }

	    return repo.findById(id).orElse(null);
	}

	@Transactional
	public Automobile save(Automobile auto) {
		return repo.save(auto);
	}
	@Transactional
	public void delete(Long id) {
		repo.findById(id).ifPresent(repo::delete);
	}
	
	@Transactional(readOnly=true)
	public Automobile findByPlate(String plate) {
		return repo.findByPlate(plate);
	}
	
	@Transactional(readOnly=true)
	public List<Automobile> findByOwner(Utente owner){
		return repo.findByOwner(owner);
	}
	
	@Transactional(readOnly=true)
	public List<Automobile> findByModelGroupByCountry(String model){
		return repo.findByModelOrderByCountry(model);
	}
}
