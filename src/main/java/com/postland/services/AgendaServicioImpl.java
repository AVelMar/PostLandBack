package com.postland.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.postland.repositories.UsuarioRepositorio;

public class AgendaServicioImpl implements AgendaServicio {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public List<?> obtenerAgendaUsuario(int id) {
		// TODO Auto-generated method stub
		obtenerBDayAmigos(id);
		obtenerEventos(id);

		return null;
	}

	@Override
	public List<?> obtenerBDayAmigos(int id) {
		// TODO Auto-generated method stub
		//usuarioRepositorio.findAllAmigos(id);
				//For each de los bday y creo una lista donde devuelvo ese dato
		return null;
	}

	@Override
	public List<?> obtenerEventos(int id) {
		// TODO Auto-generated method stub
		//usuarioRepositorio.findAllEvents(id);
		//For each date y creo una lista donde devuelvo ese dato
		return null;
	}

}
