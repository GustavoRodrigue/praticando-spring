package com.delivery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.model.Usuario;
import com.delivery.repository.UsuarioRepository;

@RestController
public class UsuarioControler {

	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
		
		Usuario user = repository.save(usuario);
		
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
		
	}
}
