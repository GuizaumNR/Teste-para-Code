package com.Teste.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Teste.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

	@Query("select i from Usuario i where i.email = :email")
	public Usuario findByEmail(String email);
	
	@Query("select g from Usuario g where g.user = :user and g.senha = :senha")
	public Usuario buscarLogin(String user, String senha);
	
}
