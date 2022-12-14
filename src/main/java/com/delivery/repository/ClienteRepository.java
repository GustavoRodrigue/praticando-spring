package com.delivery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.model.Cliente;
import com.delivery.model.Usuario;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
