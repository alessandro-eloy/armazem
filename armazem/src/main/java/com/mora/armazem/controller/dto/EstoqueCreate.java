package com.mora.armazem.controller.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class EstoqueCreate {
	private Long id;
	private LocalDate dataSaida;
	private Long idUsuario;
	private Long idProduto;
}
