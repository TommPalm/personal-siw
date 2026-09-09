package it.uniroma3.siw.dto;
import it.uniroma3.siw.model.*;


/*il DTO espone non l'entità, ma solo i metodi utili al frontend*/
public class TicketDTO {

	private Long id;
	private String description;
	private String state;
	private String estimatedTime;
	private float cost;
	
	public TicketDTO(Ticket ticket) {
		this.id = ticket.getId();
		this.description = ticket.getDescription();
		this.state = ticket.getState();
		this.estimatedTime = ticket.getEstimatedTime();
		this.cost = ticket.getCost();
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getState() {
		return state;
	}

	public String getEstimatedTime() {
		return estimatedTime;
	}

	public float getCost() {
		return cost;
	}
	
	
}
