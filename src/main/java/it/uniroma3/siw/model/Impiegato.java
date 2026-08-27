package it.uniroma3.siw.model;


import java.util.*;
import jakarta.persistence.*;

@Entity
public class Impiegato {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy="mechanic")
	private List<Attrezzo> tools;
	@OneToOne
	private Credenziali credentials;
	@OneToMany(mappedBy="mechanic")
	private List<Auto> cars;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Attrezzo> getTools() {
		return tools;
	}
	public void setTools(List<Attrezzo> tools) {
		this.tools = tools;
	}
	public Credenziali getCredentials() {
		return credentials;
	}
	public void setCredentials(Credenziali credentials) {
		this.credentials = credentials;
	}
	public List<Auto> getCars() {
		return cars;
	}
	public void setCars(List<Auto> cars) {
		this.cars = cars;
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
		Impiegato other = (Impiegato) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
