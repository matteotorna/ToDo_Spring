package com.example.demo.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Task;
import com.example.demo.model.Utente;

public class LoginResponseDTO {
	
	private UtenteDTO utente;
	private List<TaskDTO> lista;
	public LoginResponseDTO() {
	}
	public UtenteDTO getUtente() {
		return utente;
	}
	public List<TaskDTO> getLista() {
		return lista;
	}
	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}
	public void setLista(List<TaskDTO> lista) {
		this.lista = lista;
	}
	
	public LoginResponseDTO (Utente u, List<Task> l) {
		
		utente = new UtenteDTO(u);
		lista = new ArrayList<TaskDTO>();
		
		for(Task t : l) {
			
			TaskDTO ta = new TaskDTO(t);
			lista.add(ta);
		}
	}
}
