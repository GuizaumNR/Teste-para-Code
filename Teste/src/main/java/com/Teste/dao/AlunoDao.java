package com.Teste.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Teste.model.Aluno;

public interface AlunoDao extends JpaRepository<Aluno, Integer> {

	@Query("select g from Aluno g where g.status ='ATIVO'") // o "g" seria o *, pode ser qualquer letra
	public List<Aluno> findByStatusAtivos();
	
	@Query("select g from Aluno g where g.status ='INATIVO'") 
	public List<Aluno> findByStatusInativos();
	
	@Query("select g from Aluno g where g.status ='TRANCADO'") 
	public List<Aluno> findByStatusTrancados();
	
	@Query("select g from Aluno g where g.status ='CANCELADO'") 
	public List<Aluno> findByStatusCancelados();
	
	public List<Aluno> findByNomeContainingIgnoreCase(String nome);
}
