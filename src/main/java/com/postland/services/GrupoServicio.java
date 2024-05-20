package com.postland.services;

import java.util.List;

import com.postland.dtos.GrupoDTO;
import com.postland.entities.Grupo;

public interface GrupoServicio {
	List<GrupoDTO> obtenerTodos();
	GrupoDTO obtenerGrupoPorId(int id);
}
