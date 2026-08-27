package it.uniroma3.siw.model;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	@OneToMany(mappedBy="owner")
	private List<Auto> auto;
	@OneToOne(cascade = CascadeType.ALL)
	private Credenziali credentials;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Auto> getAuto() {
		return auto;
	}
	public void setAuto(List<Auto> auto) {
		this.auto = auto;
	}
	public Credenziali getCredentials() {
		return credentials;
	}
	public void setCredentials(Credenziali credentials) {
		this.credentials = credentials;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

	
}
