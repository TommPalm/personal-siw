package it.uniroma3.siw.model;

import java.time.*;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	@Column(length=2000)
	private String description;
	@Enumerated(EnumType.STRING)
	private Stato state; 
	private LocalDate endDate;  //y-m-d
	private LocalDate startDate;
	private float cost;
	

	@ManyToOne 
	private Auto auto;
	@OneToMany(mappedBy="ticket")
	private List<Ricambio> parts;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Stato getState() {
		return state;
	}
	public void setState(Stato state) {
		this.state = state;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Auto getAuto() {
		return auto;
	}
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	public List<Ricambio> getParts() {
		return parts;
	}
	public void setParts(List<Ricambio> parts) {
		this.parts = parts;
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
		Ticket other = (Ticket) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
