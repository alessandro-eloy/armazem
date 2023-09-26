package com.mora.armazem.controller.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mora.armazem.entity.Estoque;

	
/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */


public class EstoqueDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataSaida = LocalDateTime.now();
	private Long usuario;
	private String produto;
	private String nomeUsuario;
	private String nomeProduto;
	
	public EstoqueDto() {
		super();
	}

	public EstoqueDto(Estoque obj) {
		this.id = obj.getId();
		this.dataSaida = obj.getDataSaida();
		this.usuario = obj.getUsuario().getCod();
		this.produto = obj.getProduto().getCodigo();
		this.nomeUsuario = obj.getUsuario().getNome();
		this.nomeProduto = obj.getProduto().getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	
}
