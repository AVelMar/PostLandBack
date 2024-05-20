package com.postland.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.postland.entities.Publicacion;

@Repository
public interface PublicacionRepositorio extends JpaRepository<Publicacion, Integer>{
	Publicacion findOneById(int id);
	List<Publicacion> findByUserId(int id);
	List<Publicacion> findByGrupoId(int id);
	@Query("Select p from Publicacion p where grupo=null")
	List<Publicacion> findAllUsers();
	@Query("Select p from Publicacion p where grupo!=null")
	List<Publicacion> findAllGroups();
	/*@Query("Select p from Publicacion p where grupo=null and usuario=(Select u2 from UsuarioAmigo u2 where user)")
	List<Publicacion> findAllGroups
	
	obtenerUsuarioPublicacionesGrupos
	obtenerUsuarioPublicacionesAmigos*/
	@Query("Select p from Publicacion p where evento != null")
	List<Publicacion> findAllEvents();
}
