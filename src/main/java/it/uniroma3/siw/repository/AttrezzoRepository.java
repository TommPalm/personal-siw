package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.*;
import java.util.*;
import it.uniroma3.siw.model.*;

public interface AttrezzoRepository extends JpaRepository<Attrezzo, Long> {

	Attrezzo findByName(String name);
	List<Attrezzo> findByStationOrderByName(String Station);
	List<Attrezzo> findByMechanic(Impiegato mechanic);
}
