package com.mora.armazem.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/*
* @author Ayowole_Agbedejobi and Alessandro_Eloy
*/

@Entity
@Data
public class Estoque {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date dataSaida;
	private String quantidade;
	private String usuario;
	private String produto;
}
