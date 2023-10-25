package com.mora.armazem.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mora.armazem.controller.dto.UsuarioDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;

/*
* @author Ayowole_Agbedejobi and Alessandro_Eloy
*/

@Entity
public class Usuario implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String login;
	
	private String senha;
	private UserRole role;
	
	@OneToMany(mappedBy = "usuario" )
	private List<Estoque> estoques = new ArrayList<Estoque>();
	
	
	
	public Usuario() {
		super();
	}
	
	public Usuario(String login, String senha, UserRole role) {
		this.login = login;
		this.senha = senha;
		this.role = role;
	}


	public Usuario(Integer id, String login, String senha, UserRole role, List<Estoque> estoques) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.role = role;
		this.estoques = estoques;
	}


	public Usuario(@Valid UsuarioDto objDto, Integer id) {
		this.id = id;
	
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


	public List<Estoque> getEstoques() {
		return estoques;
	}


	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UserRole.ADMIN)return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}


	@Override
	public String getUsername() {
		return login;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}
	
}



	
