package it.uniroma3.siw.model;

public class Ticket {

	private Integer id;
	private String client;
	private String conto;  // aperto o chiuso
	
	
	
	/*****setter and getter******/
	public Integer getId() {
		return id;
	}
	public void setId(Integer name) {
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
