package com.mora.armazem.controller.dto;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

import lombok.Data;

@Data
public class ProdutoDto {
	private String codigo;
	private String nome;
	private Long quantidade;
}
