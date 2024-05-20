package com.postland.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.postland.entities.InvitacionAmistad;
import com.postland.entities.InvitacionGrupo;

@Repository
public interface InvitacionAmistadRepositorio extends JpaRepository<InvitacionAmistad, Integer>{
	InvitacionAmistad findOneById(int id);
	@Query("Select i from InvitacionAmistad i where idAnfitrion = :id")
	List<InvitacionAmistad> findByUserAnfitrionId(int id);
	@Query("Select i from InvitacionAmistad i where idInvitado = :id")
	List<InvitacionAmistad> findByUserInvitadoId(int id);
}
