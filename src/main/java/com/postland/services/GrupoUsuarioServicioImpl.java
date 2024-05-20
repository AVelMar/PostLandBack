package com.postland.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postland.dtos.GrupoDTO;
import com.postland.dtos.GrupoUsuarioDTO;
import com.postland.dtos.UsuarioDTO;
import com.postland.entities.GrupoUsuario;
import com.postland.repositories.GrupoRepositorio;
import com.postland.repositories.GrupoUsuarioRepositorio;
import com.postland.repositories.UsuarioRepositorio;

@Service
public class GrupoUsuarioServicioImpl implements GrupoUsuarioServicio{
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	GrupoUsuarioRepositorio grupoUsuarioRepositorio;
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	@Autowired
	GrupoRepositorio grupoRepositorio;
	@Override
	public List<UsuarioDTO> obtenerUsuariosPorGrupoId(int id) {
		return grupoUsuarioRepositorio.findUsersByGroupId(grupoRepositorio.findOneById(id)).stream().map(u -> modelMapper.map(u, UsuarioDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<GrupoDTO> obtenerGruposPorUsuarioId(int id) {
		return grupoUsuarioRepositorio.findGroupsByUserId(usuarioRepositorio.findOneById(id)).stream().map(g -> modelMapper.map(g, GrupoDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<GrupoUsuarioDTO> findAllByGrupoId(int id) {
		return grupoUsuarioRepositorio.findAllByGrupoId(grupoRepositorio.findOneById(id)).stream().map(g -> modelMapper.map(g, GrupoUsuarioDTO.class)).collect(Collectors.toList());
	}
	
	/*	private int id;
	
	private GrupoDTO grupo;

	private UsuarioDTO usuario;
	
	private RolGrupo rol;*/

}
