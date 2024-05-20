package com.postland.repositories;

import org.springframework.stereotype.Repository;

import com.postland.entities.Comentario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, Integer>{

}