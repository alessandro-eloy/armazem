package com.mora.armazem.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mora.armazem.controller.dto.ProdutoDto;

/*
 * 
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique=true)
	private String codigo;
	
	@Column(unique=true)
	private String nome;
	
	private Long quantidade;
	
	@OneToMany(mappedBy = "produto" )
	private List<Estoque> estoques = new ArrayList<Estoque>();

	public Produto() {
		super();
		
	}
	
	public Produto(ProdutoDto obj) {
		super();
		this.id = obj.getId();
		this.codigo = obj.getCodigo();
		this.nome = obj.getNome();
		this.quantidade = obj.getQuantidade();
	}

	public List<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
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