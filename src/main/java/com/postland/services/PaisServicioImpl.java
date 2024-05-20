package com.postland.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postland.dtos.PaisDTO;
import com.postland.repositories.PaisRepositorio;

@Service
public class PaisServicioImpl implements PaisServicio {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	PaisRepositorio paisRepositorio;
	@Override
	public List<PaisDTO> obtenerTodos(){
		return paisRepositorio.findAll().stream().map(p -> modelMapper.map(p, PaisDTO.class)).collect(Collectors.toList());
	}
}