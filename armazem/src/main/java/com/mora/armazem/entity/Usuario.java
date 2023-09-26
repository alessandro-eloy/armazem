package com.mora.armazem.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mora.armazem.controller.dto.UsuarioDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/*
* @author Ayowole_Agbedejobi and Alessandro_Eloy
*/

@Entity
public class Usuario implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@Column(unique = true)
	private Long cod;
	private String nivelAcesso;
	
	@OneToMany(mappedBy = "usuario" )
	private List<Estoque> estoques = new ArrayList<Estoque>();
	
	
	public Usuario() {
		super();
	}
	
	public Usuario(UsuarioDto obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cod = obj.getCod();
		this.nivelAcesso = obj.getNivelAcesso();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCod() {
		return cod;
	}

	public void setCod(Long cod) {
		this.cod = cod;
	}

	public String getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	public List<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}
	
	
}



	
