package com.postland.services;

import java.util.List;

public interface AgendaServicio {
	List<?> obtenerAgendaUsuario(int id);
	List<?> obtenerBDayAmigos(int id);
	List<?> obtenerEventos(int id);
}
