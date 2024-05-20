package com.postland.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postland.dtos.GrupoDTO;
import com.postland.dtos.UsuarioDTO;
import com.postland.entities.Grupo;
import com.postland.repositories.GrupoRepositorio;

@Service
public class GrupoServicioImpl implements GrupoServicio{
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	GrupoRepositorio grupoRepositorio;
	@Override
	public List<GrupoDTO> obtenerTodos() {
		// TODO Auto-generated method stub
		return grupoRepositorio.findAll().stream().map(g -> modelMapper.map(g, GrupoDTO.class)).collect(Collectors.toList());
	}
	@Override
	public GrupoDTO obtenerGrupoPorId(int id) {
		// TODO Auto-generated method stub
		return modelMapper.map( grupoRepositorio.findOneById(id), GrupoDTO.class);
	}
	
}
