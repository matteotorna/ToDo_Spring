package com.example.demo.dto.request.task;

import java.time.LocalDate;

import com.example.demo.model.Task;

public class ListaTaskRequestDTO {
	
	private long idUtente;

	
	public long getIdUtente() {
		return idUtente;
	}


	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}

	
	public ListaTaskRequestDTO(long idUtente) {
		this.idUtente = idUtente;
	}

	
	public ListaTaskRequestDTO() {
	}

	public boolean isValid() {
		return false;
	}
	
	
	
	
	
	
	
	
}
