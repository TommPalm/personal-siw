package it.uniroma3.siw.model;

import java.util.Objects;

import jakarta.persistence.*;

public class Credenziali {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	@Column(unique=true)
	private int phoneNumber;
	@Column(unique=true)
	private String username;
	private String password;
	@Enumerated(EnumType.STRING)
	private Ruolo role;
	
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Ruolo getRole() {
		return role;
	}
	public void setRole(Ruolo role) {
		this.role = role;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credenziali other = (Credenziali) obj;
		return Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	
	
}
