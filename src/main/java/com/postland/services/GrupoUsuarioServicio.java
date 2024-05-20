package com.postland.services;

import java.util.List;

import com.postland.dtos.GrupoDTO;
import com.postland.dtos.GrupoUsuarioDTO;
import com.postland.dtos.UsuarioDTO;

public interface GrupoUsuarioServicio {
	List<UsuarioDTO> obtenerUsuariosPorGrupoId(int id);
	List<GrupoDTO> obtenerGruposPorUsuarioId(int id);
	List<GrupoUsuarioDTO> findAllByGrupoId(int id);
}
