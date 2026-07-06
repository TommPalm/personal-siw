package it.uniroma3.siw.model;

import jakarta.persistence.*;

@Entity
public class Ricambio {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	@Column(nullable=false,unique=true)
	private String nome;
	private String produttore;
	@Column(nullable=false)
	private int quanto;
	
	public Ricambio(String n, String p,int q) {
		this.nome=n;
		this.produttore=p;
		this.quanto=q;
	}

	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProduttore() {
		return produttore;
	}
	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}
	public int getQuanto() {
		return quanto;
	}
	public void setQuanto(int quanto) {
		this.quanto = quanto;
	}
	public Integer getId() {
		return this.id;
	}
	
	
	
	
	@Override
	public int hashCode() {
		return this.getId();
	}
	
	
	@Override
	public boolean equals(Object o) {
		Ricambio that = (Ricambio) o;
		return this.getId()!=null  && this.getId()==that.getId();
	}
	
	
	
	
	
}
