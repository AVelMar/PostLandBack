package com.postland.dtos;

import java.io.Serial;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.postland.entities.Grupo;
import com.postland.entities.Usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InvitacionGrupoDTO {

	private int id;
	
	private UsuarioDTO usuarioAnfitrion;

	private UsuarioDTO usuarioInvitado;

	private GrupoDTO grupoInvitado;
	
	private Boolean aceptada;
	private LocalDate f_envio;
}
