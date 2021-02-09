package com.Teste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.Teste.Enums.Curso;
import com.Teste.Enums.Status;
import com.Teste.Enums.Turno;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="nome")
	@Size(min = 5, max = 30, message="O nome deve conter no mínimo 5 caracteres.")
	@NotBlank(message = "O nome não pode ser vazio.")
	private String nome;
	
	@Column(name="curso")
	@Enumerated(EnumType.STRING)
	@NotNull(message="O curso não pode ser nulo.")
	private Curso curso;
	
	@Column(name="matricula")
	@NotNull(message="O campo matricula não pode ser nulo, favor gerar uma matricula antes de continuar.")
	@Size(min = 3, message="O campo matricula deve conter no mínimo 3 caracteres.")
	private String matricula;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	@NotNull(message="O status não pode ser nulo.")
	private Status status;
	
	@Column(name="turno")
    @Enumerated(EnumType.STRING)
	@NotNull(message="O turno não pode ser nulo.")
	private Turno turno;
	
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	} 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
