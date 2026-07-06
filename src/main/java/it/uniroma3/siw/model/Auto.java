package it.uniroma3.siw.model;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Auto {

	@Id
	@Column(unique=true)
	private String targa;
	private String paese; //paese immatricolazione
	private String modello;
	
	@OneToMany
	private List<Task> lavori;
	
	public Auto(String t, String p, String m) {
		this.targa=t;
		this.paese=p;
		this.modello=m;
		this.lavori = new ArrayList<Task>();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void setTarga(String t) {
		this.targa=t;
	}
	public void setModello(String m) {
		this.modello=m;
	}
	public void setPaese(String p) {
		this.paese=p;
	}
	public String getTarga() {
		return this.targa;
	}
	public String getModello() {
		return this.modello;
	}
	public String getPaese() {
		return this.paese;
	}
	
	public void addTask(Task t) {
		this.lavori.add(t);
	}
	public List<Task> getLavori(){
		return this.lavori;
	}
	
	
	@Override
	public boolean equals(Object o) {
		Auto that = (Auto) o;
		return this.getTarga().equals(that.getTarga()) && this.getPaese().equals(that.getPaese());
	}
	
	@Override
	public int hashCode() {
		return this.getTarga().hashCode()*33 + this.getPaese().hashCode()*31;
	}
	
	
	
	
	
	
	
	
	
}
