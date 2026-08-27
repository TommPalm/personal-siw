package it.uniroma3.siw.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw.model.*;
import java.util.*;
import it.uniroma3.siw.repository.*;

@Service
public class CradenzialiService {

	private final PasswordEncoder passwordEncoder;
	private final CredenzialiRepository repo;

	public CradenzialiService(PasswordEncoder passEncod, CredenzialiRepository repo) {
		this.passwordEncoder = passEncod;
		this.repo = repo;
	}
	
	@Transactional
	public Credenziali findById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	@Transactional
    public Credenziali saveCredentials(Credenziali credentials) {
        credentials.setRole(Ruolo.CLIENTE);
        credentials.setPassword(this.passwordEncoder.encode(credentials.getPassword()));
        return repo.save(credentials);
    }
	@Transactional
	public List<Credenziali> findAll(){
		return repo.findAll();
	}
	@Transactional
	public Credenziali findByUsernameAndPhone(String username, int phone) {
		return repo.findByUsernameAndPhoneNumber(username, phone);
	}
	@Transactional
	public Credenziali findByUsername(String username){
		return repo.findByUsername(username);
	}
}
