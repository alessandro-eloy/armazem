package com.mora.armazem.entity;

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
@SequenceGenerator(initialValue = 1, name = "seq_usuario")
@Data
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String senha;
	private String login;
	private String nivelAcesso;
}
