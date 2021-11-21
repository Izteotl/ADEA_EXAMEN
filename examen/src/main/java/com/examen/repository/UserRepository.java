package com.examen.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.examen.entity.Usuario;

public interface UserRepository extends JpaRepository<Usuario,String> {
	Optional<Usuario> findByLogin(String login);
	
	@Transactional
	@Modifying
	@Query("UPDATE Usuario U SET U.password = :newPassword, U.fechaModificacion = :fecha  WHERE U.login = :id ")
	int updatePasswordAndDate(@Param("newPassword") String password,@Param("fecha") Date fechaModificacion,@Param("id") String login);
}
