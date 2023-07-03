package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.Database;
import com.example.demo.dto.request.task.AggiuntaTaskRequestDTO;
import com.example.demo.dto.request.task.CheckTaskRequestDTO;
import com.example.demo.dto.request.task.EditTaskRequestDTO;
import com.example.demo.dto.request.task.ListaTaskRequestDTO;
import com.example.demo.dto.response.TaskDTO;
import com.example.demo.model.Task;
import com.example.demo.model.Utente;
import com.example.demo.services.TaskService;
import com.example.demo.services.UtenteService;

@RestController
@RequestMapping("/task")
public class TaskController {
	@Autowired
	UtenteService utenteService;
	@Autowired
	TaskService taskService;

	@RequestMapping(method = RequestMethod.POST, path = "/aggiungiTask")
	public ResponseEntity<TaskDTO> aggiuntaTask(@RequestBody AggiuntaTaskRequestDTO request) {
		Utente utente = utenteService.findById(request.getIdUtente());
		if(request.isValid() || utente != null) {
			Task t = new Task(utente, request.getTesto(), request.getData());
			t = taskService.aggiungiTask(t);
			if(t!=null) {
				return ResponseEntity.status(HttpStatus.OK).body(new TaskDTO(t));
			} else {

				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		} else {

			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}

	}

	@RequestMapping(method = RequestMethod.POST, path = "/checkTask") 
	public ResponseEntity checkTask(@RequestBody CheckTaskRequestDTO request) {

		if(request.isValid()) {

			if(taskService.checkTask(request.getIdTask()) != null) {
				return ResponseEntity.status(HttpStatus.OK).build();
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}

		} else {

			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}

	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/editTask") 
	public ResponseEntity editTask(@RequestBody EditTaskRequestDTO request) {

		if(request.isValid()) {

			if(taskService.editTask(request.getIdTask(), request.getTesto(), request.getData())) {
				return ResponseEntity.status(HttpStatus.OK).build();
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}

		} else {

			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}

	}


	@RequestMapping(method = RequestMethod.POST, path = "/listaTask") 
	public ResponseEntity listaTask(@RequestBody ListaTaskRequestDTO request) {
		Utente utente = utenteService.findById(request.getIdUtente());
		List<Task> tasks = taskService.listaTask(utente);
		if(tasks!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(tasks);
		} else {

			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	} 
}







