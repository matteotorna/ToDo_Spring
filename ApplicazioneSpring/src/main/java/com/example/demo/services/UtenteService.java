package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
	UtenteRepository repo;
	
	public Utente registraUtente(Utente u) {
		try {
		u=repo.save(u);
		return u;
		} catch(Exception e) {
			return null;
		}
	}
	public Utente login(String email, String password) {
		Utente u=repo.login(email, password);
		return u;
	}
	
	public Utente findById(long id) {
		return repo.findById(id).orElse(null);
	}
}
