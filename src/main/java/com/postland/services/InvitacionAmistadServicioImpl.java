package com.postland.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postland.dtos.InvitacionAmistadDTO;
import com.postland.dtos.UsuarioDTO;
import com.postland.entities.InvitacionAmistad;
import com.postland.repositories.InvitacionAmistadRepositorio;
import com.postland.repositories.UsuarioRepositorio;

@Service
public class InvitacionAmistadServicioImpl implements InvitacionAmistadServicio {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	InvitacionAmistadRepositorio invitacionAmistadRepositorio;
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	@Override
	public void aceptarInvitacion(int id) {
		InvitacionAmistad invitacion = invitacionAmistadRepositorio.findOneById(id);
		invitacion.setAceptada(true);
		invitacionAmistadRepositorio.save(invitacion);
	}

	@Override
	public void rechazarInvitacion(int id) {
		InvitacionAmistad invitacion = invitacionAmistadRepositorio.findOneById(id);
		invitacion.setAceptada(false);
		invitacionAmistadRepositorio.save(invitacion);
	}

	@Override
	public void gestionarInvitacion(int id, boolean respuesta) {
		if(respuesta) {
			aceptarInvitacion(id);
		}else {
			rechazarInvitacion(id);
		}
	}

	@Override
	public void crearInvitacion(int usuarioAnfitrion, int usuarioInvitado) {
		InvitacionAmistad invitacion = new InvitacionAmistad();
		invitacion.setF_envio(LocalDate.now());
		invitacion.setUsuarioAnfitrion(usuarioRepositorio.findOneById(usuarioAnfitrion));
		invitacion.setUsuarioInvitado(usuarioRepositorio.findOneById(usuarioInvitado));
		invitacionAmistadRepositorio.save(invitacion);
	}

	@Override
	public List<InvitacionAmistadDTO> obtenerInvitacionesEnviadas(int id) {
		return invitacionAmistadRepositorio.findByUserAnfitrionId(id).stream().map(i -> modelMapper.map(i, InvitacionAmistadDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<InvitacionAmistadDTO> obtenerInvitacionesRecibidas(int id) {
		return invitacionAmistadRepositorio.findByUserInvitadoId(id).stream().map(i -> modelMapper.map(i, InvitacionAmistadDTO.class)).collect(Collectors.toList());
	}

}
