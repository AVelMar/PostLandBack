package com.postland.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.postland.entities.InvitacionGrupo;

@Repository
public interface InvitacionGrupoRepositorio extends JpaRepository<InvitacionGrupo, Integer>{
	InvitacionGrupo findOneById(int id);
	@Query("Select i from InvitacionAmistad i where idGrupo = :id")
	List<InvitacionGrupo> findByGroupId(int id);
	@Query("Select i from InvitacionAmistad i where idAnfitrion = :id")
	List<InvitacionGrupo> findByUserAnfitrionId(int id);
	@Query("Select i from InvitacionAmistad i where idInvitado = :id")
	List<InvitacionGrupo> findByUserInvitadoId(int id);
}
