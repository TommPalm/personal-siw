package it.uniroma3.siw.model;

public class Task {
	
	private String name;
	private String descrizione;
	private Integer mechanicId;
	
	
	/******getter and setter*/
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getMechanicId() {
		return mechanicId;
	}
	public void setMechanicId(Integer mechanicId) {
		this.mechanicId = mechanicId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*******equals and hashcode********/
	@Override
	public boolean equals(Object o) {
		Task that = (Task) o;
		return this.getName().equals(that.getName()) && this.getMechanicId()==that.getMechanicId();
	}
	
	@Override
	public int hashCode() {
		return this.getMechanicId()+this.getName().hashCode()*31;
	}
}
