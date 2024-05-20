package com.postland.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import com.postland.dtos.PublicacionDTO;
import com.postland.entities.Grupo;
import com.postland.entities.Publicacion;
import com.postland.entities.Usuario;
import com.postland.repositories.PublicacionRepositorio;
import com.postland.repositories.UsuarioRepositorio;

@Service
public class PublicacionServicioImpl implements PublicacionServicio{
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	PublicacionRepositorio publicacionRepositorio;
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	@Override
	public PublicacionDTO crearPublicaicon(PublicacionDTO publicacionDTO, OAuth2Authentication auth) {
		//publicacionRepositorio.save(modelMapper.map(publicacion, Publicacion.class));
		
		Publicacion publicacion = modelMapper.map(publicacionDTO, Publicacion.class);
		publicacion.setUser(usuarioRepositorio.findOneByUsername(auth.getPrincipal().toString()));
		publicacionRepositorio.save(publicacion);
		PublicacionDTO publicacionRespuesta = modelMapper.map(publicacion, PublicacionDTO.class);
		return publicacionRespuesta;
	}

	@Override
	public List<PublicacionDTO> obtenerPublicaciones() {
		return publicacionRepositorio.findAll().stream().map(p -> modelMapper.map(p, PublicacionDTO.class)).collect(Collectors.toList());

	}
	
	@Override
	public List<PublicacionDTO> obtenerPublicacionesUsuarios() {
		return publicacionRepositorio.findAllUsers().stream().map(p -> modelMapper.map(p, PublicacionDTO.class)).collect(Collectors.toList());

	}
	
	@Override
	public List<PublicacionDTO> obtenerPublicacionesGrupos() {
		return publicacionRepositorio.findAllGroups().stream().map(p -> modelMapper.map(p, PublicacionDTO.class)).collect(Collectors.toList());

	}

	@Override
	public List<PublicacionDTO> obtenerPublicacionesUsuario(int id) {
		return publicacionRepositorio.findByUserId(id).stream().map(p -> modelMapper.map(p, PublicacionDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<PublicacionDTO> obtenerPublicacionesGrupo(int id) {
		return publicacionRepositorio.findByGrupoId(id).stream().map(p -> modelMapper.map(p, PublicacionDTO.class)).collect(Collectors.toList());

	}

	@Override
	public PublicacionDTO obtenerPublicacionPorId(int id) {
		return modelMapper.map(publicacionRepositorio.findOneById(id), PublicacionDTO.class);
	}

	@Override
	public void actualizarPublicacion(PublicacionDTO publicacion) {
		Publicacion publ = publicacionRepositorio.findOneById(publicacion.getId());
		if(publicacion.getContenido()!=null) {
			//publ.setContenido(publicacion.getContenido().stream().map(c -> modelMapper.map(c, Contenido.class)).collect(Collectors.toList()));
		}
		if(publicacion.getGrupo()!=null) {
			publ.setGrupo(modelMapper.map(publicacion.getGrupo(), Grupo.class));
		}
		if(publicacion.getUser()!=null) {
			publ.setUser(modelMapper.map(publicacion.getUser(), Usuario.class));
		}
		if(publicacion.getUsuariosFavorito()!=null) {
			publ.setUsuariosFavorito(publicacion.getUsuariosFavorito().stream().map(u -> modelMapper.map(u, Usuario.class)).collect(Collectors.toList()));
		}
		if(publicacion.getUsuariosGusta()!=null) {
			publ.setUsuariosGusta(publicacion.getUsuariosGusta().stream().map(u -> modelMapper.map(u, Usuario.class)).collect(Collectors.toList()));
		}
		if(publicacion.getPublico()!=null) {
			publ.setPublico(publicacion.getPublico());
		}
		publicacionRepositorio.save(publ);
	}

	@Override
	public void borrarPublicacion(int id) {
		publicacionRepositorio.delete(publicacionRepositorio.findOneById(id));
	}

	@Override
	public List<PublicacionDTO> obtenerUsuarioPublicacionesGrupos(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PublicacionDTO> obtenerUsuarioPublicacionesAmigos(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PublicacionDTO> obtenerPublicacionesEvento() {
		return publicacionRepositorio.findAllEvents().stream().map(p -> modelMapper.map(p, PublicacionDTO.class)).collect(Collectors.toList());
	}
	
	

	
}
