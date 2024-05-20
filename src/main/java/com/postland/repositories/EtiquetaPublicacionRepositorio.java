package com.postland.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postland.entities.EtiquetasPublicacion;

@Repository
public interface EtiquetaPublicacionRepositorio extends JpaRepository<EtiquetasPublicacion, Integer>{
	List<EtiquetasPublicacion> findAll();
}
