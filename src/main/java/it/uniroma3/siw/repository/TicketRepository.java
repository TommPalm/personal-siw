package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.*;

import it.uniroma3.siw.model.*;
import java.util.*;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	List<Ticket> findByCarOrderByCost(Automobile car);
	List<Ticket> findByState(String state );
}
