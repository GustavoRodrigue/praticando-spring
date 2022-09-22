package com.delivery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.model.Carrinho;
import com.delivery.model.Usuario;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer>{

}
