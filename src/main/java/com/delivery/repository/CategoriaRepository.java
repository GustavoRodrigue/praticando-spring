package com.delivery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.model.Categoria;
import com.delivery.model.Usuario;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
