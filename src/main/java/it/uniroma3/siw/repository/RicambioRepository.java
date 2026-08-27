package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.uniroma3.siw.model.*;
import java.util.*;

public interface RicambioRepository extends JpaRepository<Ricambio, Long> {

	List<Ricambio> findByName(String name);
	List<Ricambio> findByProducerOrderByName(String producer);
}
