package com.postland.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postland.dtos.ComentarioDTO;
import com.postland.entities.Comentario;
import com.postland.repositories.ComentarioRepositorio;
import com.postland.repositories.UsuarioRepositorio;

@Service
public class ComentarioServicioImpl implements ComentarioServicio{
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	@Autowired
	ComentarioRepositorio comentarioRepositorio;
	@Override
	public ComentarioDTO crearComentario(ComentarioDTO comentarioDTO) {
		Comentario comentario = modelMapper.map(comentarioDTO, Comentario.class);
		comentario.setUser(usuarioRepositorio.findOneById(comentarioDTO.getUser().getId()));
		comentarioRepositorio.save(comentario);
		ComentarioDTO publicacionRespuesta = modelMapper.map(comentario, ComentarioDTO.class);
		return publicacionRespuesta;
	}

}
