package com.mora.armazem.controller.dto;

import lombok.Data;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

@Data
public class UsuarioDto {
	private int id;
	private String nome;
	private String senha;
	private String login;
}