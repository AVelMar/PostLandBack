package com.postland.entities;

import java.io.Serial;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class GrupoUsuario {
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "grupoId")
	@JsonIgnore
	private Grupo grupo;
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonIgnore
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "rolId")
	@JsonIgnore
	private RolGrupo rol;	
}
