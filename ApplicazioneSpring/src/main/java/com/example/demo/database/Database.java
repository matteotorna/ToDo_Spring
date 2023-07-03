package com.example.demo.database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.demo.model.Task;
import com.example.demo.model.Utente;

public class Database {

	private static Database instance = new Database();
	
	private Database() {}
	
	public static Database getInstance() {
		return instance;
	}
	
	private List<Utente> utenti = new ArrayList<Utente>();
	private List<Task> tasks = new ArrayList<Task>();
	
	private static long idUtenteGen=1;
	private static long idTaskgen=1;
	
	public boolean registraUtente(Utente u) {
		// prendo gli utenti 
		if(utenti.stream()
				// converto la lista degli utenti in una lista
				// delle loro email
				.map(s->s.getEmail())
				// se almeno una delle email presenti è uguale 
				// a quella che voglio inserire 
				.anyMatch(s->s.equals(u.getEmail()))) {
				// l'email è gia registata e quindi non permetto 
				// la registazione
				return false;
		}
		u.setId(idUtenteGen++);
		utenti.add(u);
		return true;
	}
	
	public Utente login(String email, String password) {
		for(Utente u : utenti) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}
	
	public List<Task> list(long idUtente) {
		return tasks.stream().filter(s->s.getUtente().getId() == idUtente).filter(s-> ! s.isEliminato()).collect(Collectors.toList());
	}
	
	public Utente getUtenteById(long idUtente) {
		for(int i = 0; i < utenti.size(); i++) {
			 Utente u = utenti.get(i);
			 if(idUtente == u.getId()) {
				 return u;
			 }
		} return null;
	}

	
	public Task aggiungiTask(Task task) {
		
			task.setId(idTaskgen++);
			tasks.add(task);
			return task;
	}
	
	public boolean checkTask(long id) {
		
		for(Task t: tasks) {
			if(t.getId() == id) {
				t.setCompletato(true);
				return true;
			}
		}
		return false;
	}
	
	public List<Task> listaTask(long idUtente) {
		List<Task> tasks = new ArrayList<>();
		for(Task t: this.tasks) {
			if(t.getUtente().getId() == idUtente) {
				tasks.add(t); 
			}
		}
		return tasks;
	}
	

}
