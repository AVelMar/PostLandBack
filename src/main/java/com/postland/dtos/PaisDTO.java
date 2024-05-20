package com.postland.dtos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaisDTO {
	private int id;
	private String nombre;
	private float lat, log;
}
