package it.uniroma3.siw.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Dirigente {

	private String name;
	@Id
	private String surname;
	@Id
	private String password;
	
	public Dirigente( String n, String s, String p) {
		this.name=n;
		this.surname=s;
		this.password=p;
	}
	
	
	/*********getter and setter************/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return this.password;
	}
	public void setId(String id) {
		this.password = id;
	}
	
	/*******equals and hashcode********/
	@Override
	public boolean equals(Object o) {
		Dirigente that = (Dirigente) o;
		return this.getPassword().equals(that.getPassword()) && this.getSurname().equals(that.getSurname());
	}
	
	@Override
	public int hashCode() {
		return this.getPassword().hashCode()*31 + this.getSurname().hashCode()*33;
	}
}
