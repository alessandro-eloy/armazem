package com.mora.armazem.controller;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mora.armazem.controller.dto.EstoqueDto;
import com.mora.armazem.entity.Estoque;
import com.mora.armazem.mapper.EstoqueMapper;
import com.mora.armazem.repository.EstoqueRepository;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {
	
	@Autowired 
	private EstoqueRepository estoqueRepository;
	@Autowired
	private EstoqueMapper mapper;
	
	@GetMapping
	public List<EstoqueDto> getEstoque(){
		List<Estoque> estoques = estoqueRepository.findAll() ;
		return mapper.mapEstoquesToEstoquesDto(estoques);
	}
	
	@PostMapping
	public EstoqueDto postEstoque(@RequestBody EstoqueDto estoqueDto) {
		Estoque estoque = mapper.mapEstoqueDtoToEstoque(estoqueDto);
		
		Estoque estoqueCriado = estoqueRepository.save(estoque);
		return mapper.mapEstoqueToEstoqueDto(estoqueCriado);
	}
}
