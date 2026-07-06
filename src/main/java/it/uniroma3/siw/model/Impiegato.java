package it.uniroma3.siw.model;


import java.util.*;
import jakarta.persistence.*;

@Entity
public class Impiegato {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	@Column(unique=true,nullable=false)
	private String username;
	@Column(unique=true,nullable=false)
	private String password;
	private String ruolo; //meccanico o dirigente
	
	
	@OneToOne
	private Task task;
	@OneToMany
	private Map<String,Attrezzo> attrezzi; //chiave = nome attrezzo
	
	public Impiegato(String name, String pass, String role) {
		this.username=name;
		this.password=pass;
		this.ruolo=role;
		this.attrezzi = new HashMap<String,Attrezzo>();
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Integer getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public Task getTask() {
		return this.task;
	}
	public void setTask(Task t) {
		this.task=t;
	}
	
	public void addAttrezzo(Attrezzo a) {
		this.attrezzi.put(a.getNome(), a);
	}
	public void revomeAttrezzo(String n) {
		this.attrezzi.remove(n);
	}
	public Map<String, Attrezzo> getAttrezzi(){
		return this.attrezzi;
	}
	
	
	
	
	@Override
	public int hashCode() {
		return this.getId();
	}
	
	
	@Override
	public boolean equals(Object o) {
		Impiegato that = (Impiegato) o;
		return this.getId()!=null && this.getId()==that.getId();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
