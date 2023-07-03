package com.example.demo.dto.response;

import com.example.demo.model.Utente;

public class UtenteDTO {

	private long id;
	private String nome;
	private String cognome;
	private String email;

	public UtenteDTO() {
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public UtenteDTO (Utente utente) {
		nome=utente.getNome();
		cognome=utente.getCognome();
		id=utente.getId();
		email= utente.getEmail();
	}
	
	
	
	
	
}
