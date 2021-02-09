package com.Teste.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Teste.Exceptions.CriptoExistException;
import com.Teste.Exceptions.EmailExistsException;
import com.Teste.dao.UsuarioDao;
import com.Teste.model.Usuario;
import com.Teste.util.Util;

@Service
public class ServiceUsuario {
	
	@Autowired
	private UsuarioDao repositorioUsuario;

	public void salvarUsuario(Usuario user) throws Exception{
		
		try {
			
			if(repositorioUsuario.findByEmail(user.getEmail()) != null) {
				throw new EmailExistsException("Já existe um email cadastrado para: "+ user.getEmail());
			}
			
			user.setSenha(Util.md5(user.getSenha()));
			
		} catch (NoSuchAlgorithmException e) {
			
			throw new CriptoExistException("Erro na criptografia da senha.");
			
		}
		
	repositorioUsuario.save(user);
	
}
	
	public Usuario loginUser(String user, String senha) throws ServiceExc{
		
		Usuario userLogin = repositorioUsuario.buscarLogin(user, senha);
		return userLogin;
	}
	
	}