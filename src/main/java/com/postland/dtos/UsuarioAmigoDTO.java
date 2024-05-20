package com.postland.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.postland.entities.Usuario;

public class UsuarioAmigoDTO<UsuarioAmigoDTO> extends UsuarioDTO{
	@JsonIgnore
	private List<UsuarioAmigoDTO> amigos;
}
