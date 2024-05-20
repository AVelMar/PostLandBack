package com.postland.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.postland.dtos.EtiquetasPublicacionDTO;
import com.postland.entities.EtiquetasPublicacion;
import com.postland.repositories.EtiquetaPublicacionRepositorio;

@Service
public class EtiquetaPublicacionServicioImpl implements EtiquetaPublicacionServicio{
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	EtiquetaPublicacionRepositorio etiquetaRepositorio;
	@Override
	public List<EtiquetasPublicacionDTO> obtenerTodos() {
		return etiquetaRepositorio.findAll().stream().map(e -> modelMapper.map(e, EtiquetasPublicacionDTO.class)).collect(Collectors.toList());
	}
}
