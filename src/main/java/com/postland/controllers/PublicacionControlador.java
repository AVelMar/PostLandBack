package com.postland.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.postland.dtos.PublicacionDTO;
import com.postland.services.PublicacionServicio;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PublicacionControlador {
	@Autowired
	PublicacionServicio publicacionServicio;
	@GetMapping("/publicaciones")
	public List<?> obtenerPublicaciones(){
		return publicacionServicio.obtenerPublicaciones();
	}
	@GetMapping("/publicaciones/users")
	public List<?> obtenerPublicacionesUsuarios(){
		return publicacionServicio.obtenerPublicacionesUsuarios();
	}
	@GetMapping("/publicaciones/groups")
	public List<?> obtenerPublicacionesGrupos(){
		return publicacionServicio.obtenerPublicacionesGrupos();
	}
	@GetMapping("/publicaciones/usuario/{id}/friends")
	public List<?> obtenerUsuarioPublicacionesAmigos(@PathVariable(name="id") int id){
		return publicacionServicio.obtenerUsuarioPublicacionesAmigos(id);
	}
	@GetMapping("/publicaciones/usuario/{id}/groups")
	public List<?> obtenerUsuarioPublicacionesGrupos(@PathVariable(name="id") int id){
		return publicacionServicio.obtenerUsuarioPublicacionesGrupos(id);
	}
	@GetMapping("/publicaciones/events")
	public List<?> obtenerUsuarioPublicacionesEventos(){
		return publicacionServicio.obtenerPublicacionesEvento();
	}
	@GetMapping("/publicaciones/from/{id}")
	public ResponseEntity<?> obtenerPublicacionesPorId(
			@PathVariable(name="id") int id, @RequestParam("type") String type){
		List<PublicacionDTO> publicaciones = null;
		if(type.contains("group")) {
			publicaciones = publicacionServicio.obtenerPublicacionesGrupo(id);
		}else if(type.contains("user")) {
			publicaciones = publicacionServicio.obtenerPublicacionesUsuario(id);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		if(publicaciones==null)return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		return new ResponseEntity<>(publicaciones,HttpStatus.OK);
	}
	@PostMapping("/publicaciones")
	@Secured({"ROLE_MIEMBRO", "ROLE_ADMIN"})
	public ResponseEntity<PublicacionDTO> postPublicacion(@Valid @RequestBody PublicacionDTO publicacion, OAuth2Authentication auth){
		return new ResponseEntity<>(publicacionServicio.crearPublicaicon(publicacion, auth),HttpStatus.CREATED);
	}

}
