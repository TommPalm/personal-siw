package it.uniroma3.siw.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {


	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private String client;
	private String conto;  // aperto o chiuso
	
	public Ticket(String client, String conto) {
		this.client=client;
		this.conto=conto;
	}
	
	/*****setter and getter******/
	public int getId() {
		return id;
	}
	public void setId(int name) {
		this.id = name;
	}
	public String getSurname() {
		return client;
	}
	public void setSurname(String client) {
		this.client = client;
	}
	public String getConto() {
		return conto;
	}
	public void setConto(String conto) {
		this.conto = conto;
	}
	
	/*******equals and hashcode********/
	@Override
	public boolean equals(Object o) {
		Ticket that = (Ticket) o;
		return this.getId()==that.getId();
	}
	
	@Override
	public int hashCode() {
		return this.getId();
	}
}
