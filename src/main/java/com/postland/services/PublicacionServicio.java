package com.postland.services;

import java.util.List;

import org.springframework.security.oauth2.provider.OAuth2Authentication;

import com.postland.dtos.PublicacionDTO;

public interface PublicacionServicio {
	PublicacionDTO crearPublicaicon(PublicacionDTO publicacion, OAuth2Authentication auth);
	List<PublicacionDTO> obtenerPublicaciones();
	List<PublicacionDTO> obtenerPublicacionesUsuario(int id);
	List<PublicacionDTO> obtenerPublicacionesGrupo(int id);
	PublicacionDTO obtenerPublicacionPorId(int id);
	void actualizarPublicacion(PublicacionDTO publicaicon);
	void borrarPublicacion(int id);
	List<PublicacionDTO> obtenerPublicacionesUsuarios(); 
	List<PublicacionDTO> obtenerPublicacionesGrupos();
	List<PublicacionDTO> obtenerPublicacionesEvento();
	List<PublicacionDTO> obtenerUsuarioPublicacionesGrupos(int id);
	List<PublicacionDTO> obtenerUsuarioPublicacionesAmigos(int id);
}
