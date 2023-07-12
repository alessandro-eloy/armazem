package com.mora.armazem.controller.dto;

import lombok.Data;

@Data

public class UsuarioUpdate {
	private Long id;
	private String nome;
	private String senha;
	private String login;
	private String nivelAcesso;
}
