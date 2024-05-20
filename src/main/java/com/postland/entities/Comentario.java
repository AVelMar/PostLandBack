package com.postland.entities;

import java.io.Serial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class Comentario {
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String contenido;
	
	@ManyToOne
	@JoinColumn(name = "publicacion")
	@JsonIgnore
	private Publicacion publicacion;
	@ManyToOne
	@JoinColumn(name = "user")
	@JsonIgnore
	private Usuario user;
	
}
