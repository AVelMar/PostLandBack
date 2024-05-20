package com.postland.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/usuario")
public class AgendaControlador {
	@GetMapping("/{id}/agenda")
	public void obtenerAgendaUsuario(@PathVariable(name="id") int id) {
		
	}
	@GetMapping("/{id}/agenda/amigos")
	public void obtenerBDayAmigos(@PathVariable(name="id") int id) {
		
	}
	@GetMapping("/{id}/agenda/eventos")
	public void obtenerEventos(@PathVariable(name="id") int id) {
		
	}
}
