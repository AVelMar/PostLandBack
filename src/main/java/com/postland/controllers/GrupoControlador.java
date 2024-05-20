package com.postland.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postland.dtos.GrupoDTO;
import com.postland.services.GrupoServicio;
import com.postland.services.GrupoUsuarioServicio;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class GrupoControlador {
	@Autowired
	GrupoServicio grupoServicio;
	@Autowired
	GrupoUsuarioServicio grupoUsuarioServicio;
	@GetMapping("/grupo")
	public List<?> obtenerGrupos(){
		return grupoServicio.obtenerTodos();
	}
	@GetMapping("/grupo/{id}")
	public GrupoDTO obtenerGrupoPorId(@PathVariable(name="id") int id){
		return grupoServicio.obtenerGrupoPorId(id);
	}
	@PostMapping
	public void crearGrupo(){
	//	return grupoServicio.obtenerTodos();
	}
	@GetMapping("/usuario/{id}/grupos")
	public List<?> obtenerGruposPorUsuarioId(@PathVariable(name="id") int id){
		return grupoUsuarioServicio.obtenerGruposPorUsuarioId(id);
	}
}
