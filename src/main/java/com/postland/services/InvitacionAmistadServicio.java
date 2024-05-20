package com.postland.services;

import java.util.List;

import com.postland.dtos.InvitacionAmistadDTO;

public interface InvitacionAmistadServicio {
	void aceptarInvitacion(int id);
	void rechazarInvitacion(int id);
	void gestionarInvitacion(int id, boolean respuesta);
	void crearInvitacion(int usuarioAnfitrion, int usuarioInvitado);
	List<InvitacionAmistadDTO> obtenerInvitacionesEnviadas(int id);
	List<InvitacionAmistadDTO> obtenerInvitacionesRecibidas(int id);
	
}
