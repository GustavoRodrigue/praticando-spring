package com.delivery.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.delivery.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Optional<Usuario>  findById(Integer id); // buscar o id no banco
	
	@Query(value="select u from Usuario u where upper(trim(u.nome)) like %?1%")
	List<Usuario> BuscaPorNome(String name);
	
}
