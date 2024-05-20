package com.postland.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postland.services.PaisServicio;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/pais")
public class PaisesControlador {
	@Autowired
	PaisServicio paisServicio;
	@GetMapping
	public List<?> obtenerGrupos(){
		return paisServicio.obtenerTodos();
	}
}
