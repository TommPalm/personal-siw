package it.uniroma3.siw.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Automobile {

	@Id
	private String targa;
	private String model;
	private String problem;
	private String stato; //lavoro o pronta
	
	public Automobile(String t, String m, String p) {
		this.targa=t;
		this.model=m;
		this.problem=p;
		this.stato= "lavoro";
	}
	
	public void setPronta() {
		this.stato="pronta";
	}
	
	/*****getter and setter*/
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	
	/*******equals and hashcode********/
	@Override
	public boolean equals(Object o) {
		Automobile that = (Automobile) o;
		return this.getTarga().equals(that.getTarga());
	}
	
	@Override
	public int hashCode() {
		return this.getTarga().hashCode();
	}
}
