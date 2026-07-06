package it.uniroma3.siw.model;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	@Column(unique=true)
	private String username;
	private String password;
	
	@OneToMany
	private List<Auto> auto;
	
	public Cliente(String user, String pass) {
		this.username=user;
		this.password=pass;
		this.auto = new ArrayList<Auto>();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void setUsername(String u) {
		this.username=u;
	}
	public String getUsername() {
		return this.username;
	}
	public void setPassword(String p) {
		this.password=p;
	}
	public String getPassword() {
		return this.password;
	}
	public Integer getId() {
		return this.id;
	}
	
	public void addAuto(Auto a) {
		this.auto.add(a);
	}
	public List<Auto> getAuto(){
		return this.auto;
	}
	
	
	@Override
	public boolean equals(Object o) {
		Cliente that = (Cliente) o;
		return this.getId()!=null && this.getId()==that.getId();
	}
	
	@Override
	public int hashCode() {
		return this.getId();
	}
	
	
	
	
	
	
	
	
	
}
