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
import com.mora.armazem.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<ProdutoDto> getProduto() {
		ProdutoDto produtoDto = new ProdutoDto();
		produtoDto.setNome("marreta");
		return List.of(produtoDto);
	}
	
	@PostMapping
	public void postProduto(@RequestBody ProdutoDto produtoDto) {
		
		Produto produto = new Produto();
		produto.setCodigo(Long.valueOf(produtoDto.getCodigo()));
		produto.setNome(produtoDto.getNome());
		
		produtoRepository.save(produto);
	}
	
}
