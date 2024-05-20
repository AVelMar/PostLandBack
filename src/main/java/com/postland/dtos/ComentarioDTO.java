package com.postland.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.postland.entities.Evento;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComentarioDTO {
	private int id;
	private String contenido;
	private UsuarioDTO user;
	@JsonIgnore
	private PublicacionDTO publicacion;
}
