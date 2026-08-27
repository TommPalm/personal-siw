package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import it.uniroma3.siw.model.*;

public interface AutoRepository extends JpaRepository<Auto, Long> {

	Auto findByPlate(String plate);
	List<Auto> findByOwner(Cliente owner);
	List<Auto> findByModelGroupByCountry(String model);
}
