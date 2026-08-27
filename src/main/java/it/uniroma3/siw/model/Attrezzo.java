package it.uniroma3.siw.model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Attrezzo {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	private String name;
	private String station;	
	@ManyToOne
	private Impiegato mechanic;
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
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public Impiegato getMechanic() {
		return mechanic;
	}
	public void setMechanic(Impiegato mechanic) {
		this.mechanic = mechanic;
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
		Attrezzo other = (Attrezzo) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
