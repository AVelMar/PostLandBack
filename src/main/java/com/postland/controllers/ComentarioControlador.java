package com.postland.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postland.dtos.ComentarioDTO;
import com.postland.services.ComentarioServicio;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/publicacion")
public class ComentarioControlador {
	@Autowired
	ComentarioServicio comentarioServicio;
	
	@Secured({"ROLE_ADMIN", "ROLE_MIEMBRO"})
	@PostMapping("/{id}/comentario")
	public ResponseEntity<ComentarioDTO> postPublicacion(@Valid @RequestBody ComentarioDTO comentario){
		return new ResponseEntity<>(comentarioServicio.crearComentario(comentario),HttpStatus.CREATED);
	}
}
