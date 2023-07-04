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

import com.mora.armazem.controller.dto.ProdutoDto;
import com.mora.armazem.entity.Produto;
import com.mora.armazem.mapper.ProdutoMapper;
import com.mora.armazem.repository.ProdutoRepository;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ProdutoMapper mapper;
	
	@GetMapping
	public List<ProdutoDto> getProduto() {
		List<Produto> produtos = produtoRepository.findAll();
		return mapper.mapProdutosToProdutosDto(produtos);
	}
	
	@PostMapping
	public ProdutoDto postProduto(@RequestBody ProdutoDto produtoDto) {
		
		Produto produto = mapper.mapProdutoDtoToProduto(produtoDto);
		Produto produtoCriado = produtoRepository.save(produto);
		
		return mapper.mapProdutoToProdutoDto(produtoCriado);
	}
	
}
