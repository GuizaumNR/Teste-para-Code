package com.Teste.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Teste.dao.AlunoDao;
import com.Teste.model.Aluno;

@Controller
public class AlunoController {

	@Autowired
	private AlunoDao alunoRepositorio;
	
    @GetMapping("/inserirAlunos")
	public ModelAndView InsertAlunos(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
    	mv.setViewName("Alunos/formAluno");
    	mv.addObject("aluno", new Aluno());
    	return mv;
    }
	@PostMapping("/insertAlunos")
	public ModelAndView InserirAluno(@Valid Aluno aluno, BindingResult br){
		ModelAndView mv = new ModelAndView();
		if(br.hasErrors()) {
			mv.setViewName("Alunos/formAluno");
			mv.addObject(aluno);
		}else {
		mv.setViewName("redirect:/alunos-inseridos");
		alunoRepositorio.save(aluno); 
		}
		return mv;
	}
	
	@GetMapping("alunos-inseridos")
	public ModelAndView listagemAlunos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Alunos/listAlunos");
		mv.addObject("alunosList", alunoRepositorio.findAll());
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Alunos/alterar");
		Aluno aluno = alunoRepositorio.getOne(id);
		mv.addObject("aluno", aluno);
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Aluno aluno){
		ModelAndView mv = new ModelAndView();
		alunoRepositorio.save(aluno);
		mv.setViewName("redirect:/alunos-inseridos");
		return mv;
	}

	@GetMapping("/excluir/{id}")
	public String excluirAluno(@PathVariable("id") Integer id) {
		alunoRepositorio.deleteById(id);
		return "redirect:/alunos-inseridos";
	}
	
	@GetMapping("filtro-alunos")
	public ModelAndView filtroAlunos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Alunos/filtroAlunos");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@GetMapping("alunos-ativos")
	public ModelAndView listaAlunosAtivos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Alunos/alunos-ativos");
		mv.addObject("alunosAtivos", alunoRepositorio.findByStatusAtivos());
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@GetMapping("alunos-inativos")
	public ModelAndView listaAlunosInativos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Alunos/alunos-inativos");
		mv.addObject("alunosInativos", alunoRepositorio.findByStatusInativos());
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	@GetMapping("alunos-trancados")
	public ModelAndView listaAlunosTrancados() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Alunos/alunos-trancados");
		mv.addObject("alunosTrancados", alunoRepositorio.findByStatusTrancados());
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	@GetMapping("alunos-cancelados")
	public ModelAndView listaAlunosCancelados() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Alunos/alunos-cancelados");
		mv.addObject("alunosCancelados", alunoRepositorio.findByStatusCancelados());
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@PostMapping("pesquisar-aluno")
	public ModelAndView pesquisarAluno(@RequestParam(required = false) String nome) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("aluno", new Aluno());
		List<Aluno> listaAlunos;
		if(nome == null || nome.trim().isEmpty()) {
			listaAlunos = alunoRepositorio.findAll();
		}else {
			listaAlunos = alunoRepositorio.findByNomeContainingIgnoreCase(nome);
		}
		mv.addObject("ListaDeAlunos", listaAlunos);
		mv.setViewName("Alunos/pesquisa-resultado");
		return mv;
	}
}
