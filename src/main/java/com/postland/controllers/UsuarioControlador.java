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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.postland.dtos.GrupoUsuarioDTO;
import com.postland.dtos.UsuarioDTO;
import com.postland.dtos.UsuarioNuevoDTO;
import com.postland.entities.Usuario;
import com.postland.services.GrupoUsuarioServicio;
import com.postland.services.UsuarioServicio;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class UsuarioControlador {
	@Autowired
	private UsuarioServicio usuarioServicio;
	@Autowired
	private GrupoUsuarioServicio grupoUsuarioServicio;
	
	//@Secured({"ROLE_ADMIN"})
	@GetMapping("/usuario")
	public List<?> obtenerMiembros() {
		return usuarioServicio.obtenerUsuarios();
	}
	@GetMapping("/usuario/{id}")
	public ResponseEntity<?> obtenerMiembroPorId(@PathVariable(name="id") int id, OAuth2Authentication auth) {
		UsuarioDTO miembro = usuarioServicio.obtenerUsuarioPorId(id, auth);
		if(miembro==null)return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		return new ResponseEntity<>(miembro, HttpStatus.OK);
	}
	@GetMapping("/usuario/{id}/friends")
	public ResponseEntity<?> obtenerAmigosPorId(@PathVariable(name="id") int id){
		List<UsuarioDTO> amigos = usuarioServicio.obtenerAmigosPorId(id);
		if(amigos==null)return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		return new ResponseEntity<>(amigos,HttpStatus.OK);
	}
	
	
	@PostMapping("/usuario")
	public void crearUsuario(@RequestBody UsuarioNuevoDTO user) {
		System.out.println(user);
		usuarioServicio.crearUsuario(user);
	}
	@PutMapping("/usuario/amigo/{id}")
	@Secured({"ROLE_MIEMBRO", "ROLE_ADMIN"})
	public void addFriend(@PathVariable(name="id") int amigo, OAuth2Authentication auth) {
		usuarioServicio.addFriend(amigo, auth);
	}
	@PutMapping("/usuario/publicacion/{id}")
	@Secured({"ROLE_MIEMBRO", "ROLE_ADMIN"})
	public void updateLikePost(@PathVariable(name="id") @Valid int post, OAuth2Authentication auth, @RequestBody @Valid Boolean like) {
		if(like) {
			usuarioServicio.disLikePost(post, auth);
		}else if(!like) {
			usuarioServicio.likePost(post, auth);

		}
	}
	@GetMapping("/grupo/{id}/usuarios")
	public ResponseEntity<?> obtenerUsuariosPorGrupoId(@PathVariable(name="id") int id){
		List<GrupoUsuarioDTO> usuarios = grupoUsuarioServicio.findAllByGrupoId(id);
		if(usuarios==null)return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		return new ResponseEntity<>(usuarios,HttpStatus.OK);
	}
	@PostMapping("/filetest")
	public void filetest(@RequestBody MultipartFile user) {
		System.out.println(user);
		usuarioServicio.fileTest(user);
	}
}
