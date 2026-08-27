package it.uniroma3.siw.model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Ricambio {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	@Column(nullable=false,unique=true)
	private String name;
	private String producer;
	
	@ManyToOne
	private Ticket ticket;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ricambio other = (Ricambio) obj;
		return Objects.equals(id, other.id);
	}
	
}
