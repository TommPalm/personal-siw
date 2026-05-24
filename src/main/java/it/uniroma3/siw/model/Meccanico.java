package it.uniroma3.siw.model;

public class Meccanico {

	private String name;
	private String surname;
	private Integer id;
	
	
	/************getter and setter***************/
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	/*******equals and hashcode********/
	@Override
	public boolean equals(Object o) {
		Meccanico that = (Meccanico) o;
		return this.getId()==that.getId();
	}
	
	@Override
	public int hashCode() {
		return this.getId()*33;
	}
}
