package com.postland.services;

import java.util.List;

import com.postland.dtos.InvitacionGrupoDTO;

public interface InvitacionGrupoServicio {
	List<InvitacionGrupoDTO> obtenerInvitacionesUsuario();
	List<InvitacionGrupoDTO> obtenerInvitacionesGrupo();
	void aceptarInvitacion();
	void rechazarInvitacion();
	void gestionarInvitacion();
	void crearInvitacion(int usuarioAnfitrion, int usuarioInvitado, int grupo);
}
