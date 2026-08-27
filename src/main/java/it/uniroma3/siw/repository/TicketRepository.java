package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.*;
import java.util.*;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	List<Ticket> findByAutoOrderByCost(Auto auto);
	@Query( "SELECT t FROM Ticket t" +
			"WHERE t.state = :state")
	List<Ticket> findByState(@Param("state") Stato state );
}
