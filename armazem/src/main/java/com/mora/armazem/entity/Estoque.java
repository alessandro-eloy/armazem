package com.mora.armazem.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

/*
* @author Ayowole_Agbedejobi and Alessandro_Eloy
*/

@Entity
@SequenceGenerator(initialValue = 1, name = "seq_estoque")
@Data
public class Estoque {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long quantidade;
	private LocalDate dataSaida;
	private String loginUsuario;
	private String codigoProduto;
}
