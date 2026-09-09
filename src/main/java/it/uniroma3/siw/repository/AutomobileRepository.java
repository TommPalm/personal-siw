package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import it.uniroma3.siw.model.*;

public interface AutomobileRepository extends JpaRepository<Automobile, Long> {
	
	Automobile findByPlate(String plate);
	List<Automobile> findByOwner(Utente owner);
	List<Automobile> findByModelOrderByCountry(String model);
}
