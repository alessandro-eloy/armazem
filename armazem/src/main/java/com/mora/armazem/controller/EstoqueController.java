package com.mora.armazem.controller;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mora.armazem.controller.dto.EstoqueDto;
import com.mora.armazem.controller.dto.EstoqueCreate;
import com.mora.armazem.entity.Estoque;
import com.mora.armazem.entity.Produto;
import com.mora.armazem.entity.Usuario;
import com.mora.armazem.mapper.EstoqueMapper;
import com.mora.armazem.repository.EstoqueRepository;
import com.mora.armazem.repository.ProdutoRepository;
import com.mora.armazem.repository.UsuarioRepository;


@RestController
@RequestMapping("api/estoque")
public class EstoqueController {
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstoqueMapper mapper;

	
	@GetMapping
	public List<EstoqueDto> getEstoque() {
		List<Estoque> estoque = estoqueRepository.findAll();
		return mapper.mapEstoqueToEstoqueDto(estoque);
	}
	
	@GetMapping("/{id}")
	public Estoque findById(@PathVariable Long id) {
		return estoqueRepository.findById(id).orElse(null);
		
	}
	
	
	@PostMapping
	public ResponseEntity<?> postEstoque(@RequestBody EstoqueCreate estoqueCreate) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(estoqueCreate.getIdUsuario());
		
		try {
			optionalUsuario.orElseThrow(Exception::new);			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("usuario invalido");
		}
		
		Optional<Produto> optionalProduto = produtoRepository.findById(estoqueCreate.getIdProduto());
		Produto produto = optionalProduto.orElseThrow();
		
		if (produto.getQuantidade() == null || produto.getQuantidade().longValue() <= 0) {
			return ResponseEntity.badRequest().body("nao ha produto disponivel no estoque");
		}
		
		produto.setQuantidade(produto.getQuantidade().longValue() - 1);
		produtoRepository.save(produto);
		
		Estoque estoque = mapper.mapEstoqueCreateToEstoque(estoqueCreate);
		Estoque estoqueCriado = estoqueRepository.save(estoque);
		
		EstoqueDto estoqueDto = mapper.mapEstoqueToEstoqueDto(estoqueCriado);
		
		return ResponseEntity.ok(estoqueDto);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			estoqueRepository.deleteById(id);			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok().build();
	}
}