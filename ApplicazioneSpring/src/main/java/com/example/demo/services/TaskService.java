package com.example.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.model.Utente;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository repo;
	
	
	public Task aggiungiTask(Task task) {
		return repo.save(task);
	}
	
	public Task checkTask(Long id) {
		Task t = repo.getTaskById(id);
		t.setCompletato(true);
		return repo.save(t);
	}
	
	public boolean editTask(Long id, String testo, LocalDate data) {
		Task t = repo.getTaskById(id);
		
		if(t == null) return false;
		
		t.setTesto(testo);
		t.setData(data);
		t = repo.save(t);
		return true;
	}
	
	public List<Task> listaTask(Utente utente) {
		List<Task> tasks = repo.listaTask(utente);
		return tasks;
	}
}
