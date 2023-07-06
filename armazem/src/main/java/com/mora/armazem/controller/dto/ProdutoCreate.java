package com.mora.armazem.controller.dto;

import lombok.Data;

@Data
public class ProdutoCreate {
	private Long id;
	private String codigo;
	private String nome;
	private Long quantidade;
}
