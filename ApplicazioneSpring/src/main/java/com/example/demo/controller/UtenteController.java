package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.Database;
import com.example.demo.dto.request.utente.LoginRequestDTO;
import com.example.demo.dto.request.utente.RegistrazioneDTO;
import com.example.demo.dto.response.LoginResponseDTO;
import com.example.demo.model.Task;
import com.example.demo.model.Utente;
import com.example.demo.services.TaskService;
import com.example.demo.services.UtenteService;

@RestController
@RequestMapping("/user")
public class UtenteController {
	@Autowired
	UtenteService utenteService;
	@Autowired
	TaskService taskService;
	
	
	@RequestMapping(method = RequestMethod.POST, path = "/registra")
	public ResponseEntity registrazione(@RequestBody RegistrazioneDTO request) {
		if(request.isValid()) {
			Utente u = new Utente(request.getNome(), request.getCognome(), request.getEmail(), request.getPassword());
			if(utenteService.registraUtente(u) != null) {
				return ResponseEntity.status(HttpStatus.OK).build();
			} else {
				
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		} else {
			
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
		if(request.getEmail() != null && request.getPassword() != null) {
			Utente u = utenteService.login(request.getEmail(), request.getPassword());
			if(u == null) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			} else {
				List<Task> tasks = taskService.listaTask(u);
				LoginResponseDTO response = new LoginResponseDTO(u, tasks);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
	}
	
}
