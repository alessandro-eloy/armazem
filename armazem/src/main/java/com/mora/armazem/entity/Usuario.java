package com.mora.armazem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

/*
* @author Ayowole_Agbedejobi and Alessandro_Eloy
*/

@Entity
@SequenceGenerator(initialValue = 1, name = "usuario_seq")
@Data
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String nome;
	
	@Column(nullable=false)
	private String senha;
	
	@Column(nullable=false, unique=true)
	private String login;
	
	@Column(nullable=false)
	private String nivelAcesso;
}
