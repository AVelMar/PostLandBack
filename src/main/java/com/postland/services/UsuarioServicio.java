package com.postland.services;

import java.util.List;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.multipart.MultipartFile;

import com.postland.dtos.UsuarioDTO;
import com.postland.dtos.UsuarioNuevoDTO;
import com.postland.entities.Usuario;

public interface UsuarioServicio {
	public List<UsuarioDTO> obtenerUsuarios();
	public void crearUsuario(UsuarioNuevoDTO user);
	public boolean addFriend(int amigo, OAuth2Authentication auth);
	public UsuarioDTO obtenerUsuarioPorId(int id, OAuth2Authentication auth);
	public List<UsuarioDTO> obtenerAmigosPorId(int id);
	void likePost(int id, OAuth2Authentication auth);
	void disLikePost(int id, OAuth2Authentication auth);
	public List<UsuarioDTO> obtenerUsuariosPorGrupoId(int id);
	void fileTest(MultipartFile file);
}
