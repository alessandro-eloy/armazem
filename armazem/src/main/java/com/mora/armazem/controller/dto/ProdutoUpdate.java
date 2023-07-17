package com.mora.armazem.controller.dto;

import lombok.Data;

@Data
public class ProdutoUpdate {
	private Long id;
	private String codigo;
	private String nome;
	private Long quantidade;
}
