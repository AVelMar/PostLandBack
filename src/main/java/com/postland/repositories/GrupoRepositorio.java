package com.postland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postland.entities.Grupo;

@Repository
public interface GrupoRepositorio extends JpaRepository<Grupo, Integer> {
	Grupo findOneById(int id);
}
