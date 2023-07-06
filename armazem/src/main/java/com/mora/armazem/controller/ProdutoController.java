package com.mora.armazem.controller;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mora.armazem.controller.dto.ProdutoCreate;
import com.mora.armazem.controller.dto.ProdutoDto;
import com.mora.armazem.controller.dto.ProdutoUpdate;
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
	public ProdutoDto postProduto(@RequestBody ProdutoCreate produtoCreate) {
		
		Produto produto = mapper.mapProdutoCreateToProduto(produtoCreate);
		Produto produtoCriado = produtoRepository.save(produto);
		
		return mapper.mapProdutoToProdutoDto(produtoCriado);
	}
 	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProdutoUpdate produtoUpdate) {
		if ((id == null || produtoUpdate.getId() == null) || id != produtoUpdate.getId()) {
			return ResponseEntity.badRequest().build();
		}
		
		Produto produto = mapper.mapProdutoUpdateToProduto(produtoUpdate);
		
		Produto produtoResultado = produtoRepository.save(produto);
		
		ProdutoDto produtoDtoResultado = mapper.mapProdutoToProdutoDto(produtoResultado);
		
		return ResponseEntity.ok(produtoDtoResultado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			produtoRepository.deleteById(id);			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok().build();
	}
}