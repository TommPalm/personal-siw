package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw.repository.*;
import it.uniroma3.siw.model.*;
import java.util.*;

@Service
public class AttrezzoService {

	private final AttrezzoRepository repo;

	public AttrezzoService(AttrezzoRepository repo) {
		this.repo = repo;
	}
	
	@Transactional
	public Attrezzo findByName(String name) {
		return repo.findByName(name);
	}
	
	@Transactional
	public List<Attrezzo> findAll(){
		return repo.findAll();
	}
	
	@Transactional
	public List<Attrezzo> findByStationOrderByName(String station){
		return repo.findByStationOrderByName(station);
	}
	
	@Transactional
	public List<Attrezzo> findByMechanic(Impiegato mechanic){
		return repo.findByMechanic(mechanic);
	}
	
	@Transactional(readOnly = true)
    public Optional<Attrezzo> findById(Long id){
        return repo.findById(id);
    }
	
	@Transactional
	public Attrezzo save(Attrezzo att) {
		return repo.save(att);
	}
}
