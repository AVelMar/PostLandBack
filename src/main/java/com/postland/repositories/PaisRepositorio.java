package com.postland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postland.entities.Pais;

@Repository
public interface PaisRepositorio extends JpaRepository<Pais, Integer>{

}
