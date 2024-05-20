package com.postland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postland.entities.RolUsuario;

@Repository
public interface RolRepositorio extends JpaRepository<RolUsuario, Integer>{
	RolUsuario findOneById(int id);
}