package com.postland.entities;

import java.io.Serial;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Publicacion {
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String contenido;
	private Boolean publico;
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	private Usuario user;
	
	@OneToOne
	@JoinColumn(name = "idEvento")
	private Evento evento;
	
	
	@ManyToOne
	@JoinColumn(name = "idGrupo")
	@NotFound(action=NotFoundAction.IGNORE)
	private Grupo grupo;
	
	@ManyToMany
	@JoinTable( 
	        joinColumns = @JoinColumn(
	          name = "publicacion_id", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "user_id", referencedColumnName = "id"),
	        uniqueConstraints = {@UniqueConstraint(columnNames={"publicacion_id","user_id"})})
	private List<Usuario> usuariosFavorito;
	
	@ManyToMany
	@JoinTable( 
	        joinColumns = @JoinColumn(
	          name = "publicacion_id", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "user_id", referencedColumnName = "id"),
	        uniqueConstraints = {@UniqueConstraint(columnNames={"publicacion_id","user_id"})})
	private List<Usuario> usuariosGusta;
	
	@ManyToOne
	@JoinColumn(name = "id_etiqueta")
	private EtiquetasPublicacion etiqueta;
	
	@OneToMany(mappedBy = "publicacion",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentario> comentario;
}
