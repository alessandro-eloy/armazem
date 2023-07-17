package com.mora.armazem.controller.dto;

import java.time.LocalDate;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

import lombok.Data;

@Data
public class EstoqueDto {
	private Long id;
	private LocalDate dataSaida;
	private Long idUsuario;
	private Long idProduto;
}
