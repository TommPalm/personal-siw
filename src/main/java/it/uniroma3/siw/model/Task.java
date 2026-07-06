package it.uniroma3.siw.model;

import java.time.*;
import jakarta.persistence.*;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	@Column(length=2000)
	private String desc;
	private String stato; //completato,preso in carico, in corso
	private LocalDate inizio;  //y-m-d
	private LocalDate fine;
	private int preventivo;
	
	@OneToOne
	private Impiegato meccanico; //meccanico assegnato
	@ManyToOne 
	private Auto auto;
	
	public Task(String des, LocalDate in, LocalDate out, int prev,Auto a,Impiegato mec) {
		this.desc=des;
		this.inizio=in;
		this.fine=out;
		this.preventivo=prev;
		this.auto=a;
		this.meccanico=mec;
		this.stato= "preso in carico";
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Integer getId() {
		return this.id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public LocalDate getInizio() {
		return inizio;
	}
	public void setInizio(LocalDate inizio) {
		this.inizio = inizio;
	}
	public LocalDate getFine() {
		return fine;
	}
	public void setFine(LocalDate fine) {
		this.fine = fine;
	}
	public int getPreventivo() {
		return preventivo;
	}
	public void setPreventivo(int preventivo) {
		this.preventivo = preventivo;
	}
	public Impiegato getMeccanico() {
		return meccanico;
	}
	public void setMeccanico(Impiegato meccanico) {
		this.meccanico = meccanico;
	}
	public void setAuto(Auto a) {
		this.auto=a;
	}
	public Auto getAuto() {
		return this.auto;
	}


	@Override
	public int hashCode() {
		return this.getId();
	}

	@Override
	public boolean equals(Object obj) {
		Task that = (Task) obj;
		return this.getId()!=null && this.getId()==that.getId();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
