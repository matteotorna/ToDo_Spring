package com.example.demo.dto.request.task;

import java.time.LocalDate;

public class AggiuntaTaskRequestDTO {
	
	private long idUtente;
	private String testo;
	private LocalDate data;
	
	public AggiuntaTaskRequestDTO(long idUtente, String testo, LocalDate data) {
		this.idUtente = idUtente;
		this.testo = testo;
		this.data = data;
	}
	
	public long getIdUtente() {
		return idUtente;
	}
	public String getTesto() {
		return testo;
	}
	public LocalDate getData() {
		return data;
	}
	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public AggiuntaTaskRequestDTO() {
	}
	
	public boolean isValid() {
		
		return testo != null && data != null && !testo.isBlank() && !testo.isEmpty();
	}
	
	
	
}
