package com.postland.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.postland.entities.GrupoUsuario;
import com.postland.entities.Publicacion;
import com.postland.entities.RolUsuario;
import com.postland.entities.Usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioNuevoDTO{
	
	private int id;

	private String password;

	private String username;

	private boolean activado;

	private String email;

	private String pais;

	private String avatar;

	private LocalDate fecha_nac;

	private RolUsuario rol;

}
