package com.Teste.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Teste.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

	@Query("select i from Usuario i where i.email = :email")
	public Usuario findByEmail(String email);
	
}
