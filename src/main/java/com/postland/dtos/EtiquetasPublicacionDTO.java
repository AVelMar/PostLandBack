package com.postland.dtos;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class EtiquetasPublicacionDTO {
	int id;
	String nombre;
	@JsonIgnore
	private List<PublicacionDTO> publicaciones;
}
