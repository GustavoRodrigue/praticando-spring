package com.delivery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.model.Pedido;
import com.delivery.model.Usuario;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
