package it.uniroma3.siw.model;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Auto {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	@Column(unique=true)
	private String plate;
	private String country; //paese immatricolazione
	private String model;
	
	@OneToMany(mappedBy="auto")
	private List<Ticket> tickets;
	@ManyToOne
	private Impiegato mechanics;
	@ManyToOne
	private Cliente owner;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public Impiegato getMechanics() {
		return mechanics;
	}
	public void setMechanics(Impiegato mechanics) {
		this.mechanics = mechanics;
	}
	public Cliente getOwner() {
		return owner;
	}
	public void setOwner(Cliente owner) {
		this.owner = owner;
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
		Auto other = (Auto) obj;
		return Objects.equals(id, other.id);
	}

	
}
