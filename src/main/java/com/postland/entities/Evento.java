package com.postland.entities;

import java.io.Serial;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Evento {
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//private List<Usuario> usuariosApuntados;
	//private List<Usuario> usuariosInteresados;
		
	private boolean presencial;
	private Float lat;
	private Float log;
	
	private Date fecha;
	
	@OneToOne
	@JoinColumn(name = "idPublicacion")
	private Publicacion publicacion;
}
