package com.postland.dtos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.postland.entities.Grupo;
import com.postland.entities.Publicacion;
import com.postland.entities.RolUsuario;
import com.postland.entities.Usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PublicacionDTO {

	private int id;
	private String contenido;
	private Boolean publico;
	private UsuarioDTO user;
	@NotFound(action=NotFoundAction.IGNORE)
	private GrupoDTO grupo;
	@JsonIgnore
	private List<UsuarioDTO> usuariosFavorito;
	
	private List<UsuarioDTO> usuariosGusta;
	//private Evento evento;
	private EtiquetasPublicacionDTO etiqueta;
}
