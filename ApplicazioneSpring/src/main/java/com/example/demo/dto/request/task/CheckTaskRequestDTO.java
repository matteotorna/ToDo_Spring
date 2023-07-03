package com.example.demo.dto.request.task;

public class CheckTaskRequestDTO {
	
	private long idTask;


	public CheckTaskRequestDTO(long idTask) {
		this.idTask = idTask;
	}

	public CheckTaskRequestDTO() {
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
