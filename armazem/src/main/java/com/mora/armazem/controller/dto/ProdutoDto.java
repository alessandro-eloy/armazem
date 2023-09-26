package com.mora.armazem.controller.dto;

import com.mora.armazem.entity.Produto;

import jakarta.validation.constraints.NotNull;

public class ProdutoDto {
	
	private Integer id;
	@NotNull(message = "O campo CÓDIGO é requerido")
	private String codigo;
	@NotNull(message = "O campo NOME é requerido")
	private String nome;
	@NotNull(message = "O campo Qunatidade é requerido")
	private Long quantidade;
	
	
	
	public ProdutoDto() {
		super();
	}

	public ProdutoDto(Produto obj) {
		super();
		this.id = obj.getId();
		this.codigo = obj.getCodigo();
		this.nome = obj.getNome();
		this.quantidade = obj.getQuantidade();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
	
}