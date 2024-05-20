package com.postland.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postland.services.EtiquetaPublicacionServicio;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/etiqueta")
public class EtiquetasPublicacionControlador {
	@Autowired
	EtiquetaPublicacionServicio etiquetasServicio;
	@GetMapping
	public List<?> obtenerGrupos(){
		return etiquetasServicio.obtenerTodos();
	}
}
