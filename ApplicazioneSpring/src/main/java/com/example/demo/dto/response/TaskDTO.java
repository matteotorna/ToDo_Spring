package com.example.demo.dto.response;

import java.time.LocalDate;

import com.example.demo.model.Task;

public class TaskDTO {
	private long id;
	private String testo;
	private LocalDate data;
	private boolean completato;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTesto() {
		return testo;
	}
	public LocalDate getData() {
		return data;
	}
	public boolean getCompletato() {
		return completato;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public void setCompletato(boolean completato) {
		this.completato = completato;
	}
	
	public TaskDTO() {
	}
	
	public TaskDTO(Task task) {
		id=task.getId();
		testo=task.getTesto();
		data=task.getData();
		completato=task.isCompletato();
		
	}
	
	
}
