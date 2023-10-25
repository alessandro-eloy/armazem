package com.mora.armazem.controller.dto;



import com.mora.armazem.entity.UserRole;
import com.mora.armazem.entity.Usuario;

import jakarta.validation.constraints.NotNull;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

public class UsuarioDto { 

	private Integer id;
	@NotNull(message = "O campo LOGIN é requerido")
	private String login;
	@NotNull(message = "O campo SENHA é requerido")
	private String senha;
	private UserRole role;
	
	
	public UsuarioDto() {
		super();
		
	}
	public UsuarioDto(Usuario obj) {
		super();
		this.id = obj.getId();
		this.login = obj.getLogin();
		this.senha = obj.getSenha();
		this.role = obj.getRole();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
}