package com.mora.armazem.controller.dto;

import java.sql.Date;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

import lombok.Data;

@Data
public class EstoqueDto {
	private Long id;
	private Date dataSaida;
	private String quantidade;
	private String usuario;
	private String produto;	
}
