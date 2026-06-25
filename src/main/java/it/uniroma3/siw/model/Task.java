package it.uniroma3.siw.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private String descrizione;
	private String mechanic;
	
	public Task( String d, String m) {
		this.descrizione=d;
		this.mechanic=m;
		
	}
	
	/******getter and setter*/
	public int getId() {
		return id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getMechanic() {
		return mechanic;
	}
	public void setMechanicId(String m) {
		this.mechanic = m;
	}
	
	/*******equals and hashcode********/
	@Override
	public boolean equals(Object o) {
		Task that = (Task) o;
		return this.getId()==that.getId();
	}
	
	@Override
	public int hashCode() {
		return this.getId();
	}
}
