package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.uniroma3.siw.model.*;
import java.util.*;

public interface RicambioRepository extends JpaRepository<Ricambio, Long> {

	boolean existsByNome(String nome);
	boolean existsByProducer(String producer);

	List<Ricambio> findByNome(String nome);
	List<Ricambio> findByProducerOrderByNome(String producer);
	
	Ricambio findByNomeAndProducer(String nome, String producer);
}
