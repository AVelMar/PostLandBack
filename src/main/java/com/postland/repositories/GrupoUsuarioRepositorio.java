package com.postland.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.postland.entities.Grupo;
import com.postland.entities.GrupoUsuario;
import com.postland.entities.Usuario;

@Repository
public interface GrupoUsuarioRepositorio extends JpaRepository<GrupoUsuario, Integer> {
	GrupoUsuario findOneById(int id);
	@Query("select u from Usuario u where id = (Select gu.usuario from GrupoUsuario gu where gu.grupo = :id)")
	List<Usuario> findUsersByGroupId(Grupo id);
	@Query("Select g from Grupo g where g.id = (Select gu.grupo from GrupoUsuario gu where gu.usuario = :id)")
	List<Grupo> findGroupsByUserId(Usuario id);
	@Query("Select gu from GrupoUsuario gu where gu.grupo = :id")
	List<GrupoUsuario> findAllByGrupoId(Grupo id);
}
