package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.siw.model.*;
import java.util.*;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

	
	Utente findByNome(String nome);
	List<Utente> findBySurname(String surname);
	List<Utente> findByCellphone(int cellphone);
}
