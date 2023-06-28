package com.mora.armazem.controller.dto;

import java.time.LocalDate;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

import lombok.Data;

@Data
public class PedidoDto {
	private LocalDate dataSaida;
	private String loginUsuario;
	private String codigoProduto;
}
