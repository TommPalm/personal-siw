package it.uniroma3.siw.model;

import jakarta.persistence.*;

@Entity
public class Attrezzo {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String postazione;
	private boolean disponibile;
	
	@ManyToOne
	private Impiegato mec;
	
	public Attrezzo( String n, String pos) {
		this.nome=n;
		this.postazione=pos;
		this.disponibile=true;
	}
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPostazione() {
		return this.postazione;
	}
	public void setPostazione(String postazione) {
		this.postazione = postazione;
	}
	public boolean isDisponibile() {
		return disponibile;
	}
	public void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
	}
	public Impiegato getMec() {
		return mec;
	}
	public void setMec(Impiegato mec) {
		this.mec = mec;
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
		Attrezzo that = (Attrezzo) o;
		return this.getId()!=null  && this.getId()==that.getId();
	}
	
	
	
	
	
}
