package com.mora.armazem.entity;

/*
 * 
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@SequenceGenerator(initialValue = 1, name = "seq_produto")
@Data
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String codigo;
	private String nome;
	private Long quantidade;
}