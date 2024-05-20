package com.postland.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.postland.entities.Grupo;
import com.postland.entities.GrupoUsuario;
import com.postland.entities.RolUsuario;
import com.postland.entities.Usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GrupoDTO {
private int id;
	
	private String nombre;
	private String descripcion;
	private boolean publico;
	@JsonIgnore
	private List<GrupoUsuarioDTO> usuarios = new ArrayList<>();
}
