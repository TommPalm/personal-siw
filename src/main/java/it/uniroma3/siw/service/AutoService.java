package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import it.uniroma3.siw.repository.*;
import it.uniroma3.siw.model.*;

@Service
public class AutoService {

	private final AutoRepository repo;

	public AutoService(AutoRepository repo) {
		this.repo = repo;
	}
	
	@Transactional
	public List<Auto> findAll(){
		return repo.findAll();
	}
	
	@Transactional
	public Optional<Auto> findById(Long id) {
		return repo.findById(id);
	}
	
	@Transactional
	public Auto save(Auto auto) {
		return repo.save(auto);
	}
	
	@Transactional
	public Auto findByPlate(String plate) {
		return repo.findByPlate(plate);
	}
	
	@Transactional
	public List<Auto> findByOwner(Cliente owner){
		return repo.findByOwner(owner);
	}
	
	@Transactional
	public List<Auto> findByModelGroupByCountry(String model){
		return repo.findByModelGroupByCountry(model);
	}
}
