package com.mora.armazem.controller.dto;



import com.mora.armazem.entity.Usuario;

import jakarta.validation.constraints.NotNull;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

public class UsuarioDto { 

	private Integer id;
	@NotNull(message = "O campo NOME é requerido")
	private String nome;
	@NotNull(message = "O campo CÓDIGO é requerido")
	private Long cod;
	private String nivelAcesso;
	
	
	public UsuarioDto() {
		super();
		
	}
	public UsuarioDto(Usuario obj) {
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
	
	
	
}