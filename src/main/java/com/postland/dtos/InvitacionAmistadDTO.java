package com.postland.dtos;

import java.io.Serial;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.postland.entities.Usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InvitacionAmistadDTO {

	private int id;

	private UsuarioDTO usuarioAnfitrion;

	private UsuarioDTO usuarioInvitado;
	
	private Boolean aceptada;
	private LocalDate f_envio;
}
