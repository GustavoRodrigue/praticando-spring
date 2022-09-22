package com.delivery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.model.Produtos;
import com.delivery.model.Usuario;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Integer>{

}
