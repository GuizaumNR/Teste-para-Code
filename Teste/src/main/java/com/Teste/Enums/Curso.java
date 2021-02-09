package com.Teste.Enums;

public enum Curso {

	ADMISTRACAO("Administracao"),
	INFORMATICA("Informatica"),
	EDFICACAO("Edficacao"),
	PROGRAMACAO("Programacao"),
	ENFERMAGEM("Enfermagem");
	
	private String curso;
	
	private Curso(String curso) {
		this.curso = curso;
	}
}
