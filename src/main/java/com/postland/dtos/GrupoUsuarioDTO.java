package com.postland.dtos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.postland.entities.Grupo;
import com.postland.entities.GrupoUsuario;
import com.postland.entities.RolGrupo;
import com.postland.entities.RolUsuario;
import com.postland.entities.Usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GrupoUsuarioDTO{
	@JsonIgnore
	private int id;
	@JsonIgnore
	private GrupoDTO grupo;

	private UsuarioDTO usuario;
	
	private RolGrupo rol;
}
