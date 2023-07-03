package com.example.demo.dto.request.task;

import java.time.LocalDate;

public class EditTaskRequestDTO {
	private long idTask;
	private String testo;
	private LocalDate data;
	
	public EditTaskRequestDTO() {}
	
	public EditTaskRequestDTO(long idTask, String testo, LocalDate data) {
		this.idTask = idTask;
		this.testo = testo;
		this.data = data;
	}

	public String getTesto() {
		return testo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public long getIdTask() {
		return idTask;
	}

	public void setIdTask(long idTask) {
		this.idTask = idTask;
	}

	public boolean isValid() {
		return idTask>0;
	}
	
}
