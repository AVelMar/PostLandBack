package com.postland.entities;

import java.io.Serial;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.JoinTable;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String password;
	@Column(unique = true)
	private String username;
	@Column
	private boolean activado;
	@Column(unique = true)
	private String email;
	@ManyToOne
	@JoinColumn(name = "pais")
	@JsonIgnore
	private Pais pais;
	@Column
	private String avatar;
	@Column
	private LocalDate fecha_nac;
	@ManyToOne
	@JoinColumn(name = "idRol")
	private RolUsuario rol;
	@JsonIgnore
	@OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<GrupoUsuario> grupos;
	@ManyToMany
	@JoinTable( 
	        joinColumns = @JoinColumn(
	          name = "user1_id", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "user2_id", referencedColumnName = "id"),
	        uniqueConstraints = {@UniqueConstraint(columnNames={"user1_id","user2_id"})})
	private List<Usuario> amigos = new ArrayList<>();
	
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Comentario> comentarios;
	
	@ManyToMany
	@JoinTable(name="publicacionesGusta")
	private List<Publicacion> publicacionesGusta;
	
	@ManyToMany
	private List<Publicacion> publicacionesFav;
}
