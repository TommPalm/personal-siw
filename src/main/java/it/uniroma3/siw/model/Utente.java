package it.uniroma3.siw.model;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Utente {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String surname;
	@Column(nullable=false)
	private int cellphone;
	
	@OneToMany(mappedBy="owner",cascade=CascadeType.ALL,  fetch = FetchType.EAGER)
	private List<Automobile> car;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String name) {
		this.nome = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getCellphone() {
		return cellphone;
	}
	public void setCellphone(int cellphone) {
		this.cellphone = cellphone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Automobile> getCar() {
		return car;
	}
	public void setCar(List<Automobile> car) {
		this.car = car;
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
		Utente other = (Utente) obj;
		return Objects.equals(id, other.id);
	}

	
}
