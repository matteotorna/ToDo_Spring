package com.example.demo.dto.request.utente;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RegistrazioneDTO {
	
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String passwordRipetuta;
	
	public RegistrazioneDTO() {}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordRipetuta() {
		return passwordRipetuta;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordRipetuta(String passwordRipetuta) {
		this.passwordRipetuta = passwordRipetuta;
	}
	@JsonIgnore
	public boolean isValid() {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		return nome!= null && cognome!= null && email!= null 
				&& password!= null && passwordRipetuta!= null 
				&& !nome.isBlank() && !nome.isEmpty() && !cognome.isBlank()
				&& !cognome.isEmpty() && email.matches(regex);
				//&& password.matches(regex);
	}
	
}
