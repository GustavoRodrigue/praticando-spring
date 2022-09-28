package com.delivery.controllers;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Usuario usuario){
		
		if(usuario.getId() == null) {
			return new ResponseEntity<String>("Id não foi informado para atualizar.", HttpStatus.OK);
		}
		
		Usuario user = usuarioRepository.saveAndFlush(usuario);
    	
    	return new ResponseEntity<Usuario>(user, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Integer idUser){
		
		Optional<Usuario> obj = usuarioRepository.findById(idUser);
			
		

		usuarioRepository.deleteById(idUser);
		
		return new ResponseEntity<String>("Usuario deletado com sucesso!", HttpStatus.OK);
		
	}
	
}
