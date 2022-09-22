package com.delivery.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.delivery.model.enuns.Status;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "carrinho_id")
	private Carrinho carrinho;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "STATUS")
	private Set<Integer> status = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime data = LocalDateTime.now();
	
	
	

	public Pedido() {
		super();
		addStatus(Status.ABERTO);
		
	}

	public Pedido(Integer id, Carrinho carrinho, Cliente cliente, Set<Integer> status, LocalDateTime data) {
		super();
		this.id = id;
		this.carrinho = carrinho;
		this.cliente = cliente;
		this.status = status;
		this.data = data;
		addStatus(Status.ABERTO);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Status> getStatus() {
		return status.stream().map(x -> Status.toEnum(x)).collect(Collectors.toSet());
		
	}
	public void addStatus(Status status) {
		this.status.add(status.getCodigo());
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	
}
