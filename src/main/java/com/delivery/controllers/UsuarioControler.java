package com.delivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.model.Usuario;
import com.delivery.repository.UsuarioRepository;

@RestController
public class UsuarioControler {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
		
		Usuario user = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "listatodos")
	@ResponseBody
	public ResponseEntity<List<Usuario>> listaUsuario(){
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "buscarid")
	@ResponseBody
	public ResponseEntity<Usuario> buscarUserId(@RequestParam(name="idUser") Integer idUser){
		
		Usuario usuario = usuarioRepository.findById(idUser).get();
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		
	}
	
}
