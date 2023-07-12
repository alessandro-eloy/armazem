package com.mora.armazem.controller.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class EstoqueUpdate {
	private Long id;
	private Long quantidade;
	private LocalDate dataSaida;
	private String loginUsuario;
	private String codigoProduto;
}
