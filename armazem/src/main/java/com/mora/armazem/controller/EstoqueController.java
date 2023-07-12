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

import com.mora.armazem.controller.dto.EstoqueDto;
import com.mora.armazem.controller.dto.EstoqueUpdate;
import com.mora.armazem.controller.dto.EstoqueCreate;
import com.mora.armazem.entity.Estoque;
import com.mora.armazem.mapper.EstoqueMapper;
import com.mora.armazem.repository.EstoqueRepository;

@RestController
@RequestMapping("api/estoque")
public class EstoqueController {
	
	@Autowired
	private EstoqueRepository EstoqueRepository;
	@Autowired
	private EstoqueMapper mapper;
	
	@GetMapping
	public List<EstoqueDto> getEstoque() {
		List<Estoque> Estoque = EstoqueRepository.findAll();
		return mapper.mapEstoqueToEstoqueDto(Estoque);
	}
	
	@GetMapping("/{id}")
	public Estoque findById(@PathVariable Long id) {
		return EstoqueRepository.findById(id).orElse(null);

	}
	
	
	@PostMapping
	public EstoqueDto postEstoque(@RequestBody EstoqueCreate estoqueCreate) {
		
		Estoque estoque = mapper.mapEstoqueCreateToEstoque(estoqueCreate);
		Estoque estoqueCriado = EstoqueRepository.save(estoque);
		
		return mapper.mapEstoqueToEstoqueDto(estoqueCriado);
	}
 	
	@PutMapping("/{id}")
	public ResponseEntity<EstoqueDto> update(@PathVariable Long id, @RequestBody EstoqueUpdate estoqueUpdate) {
		if ((id == null || estoqueUpdate.getId() == null) || id != estoqueUpdate.getId()) {
			return ResponseEntity.badRequest().build();
		}
		
		Estoque estoque = mapper.mapEstoqueUpdateToEstoque(estoqueUpdate);
		
		Estoque estoqueResultado = EstoqueRepository.save(estoque);
		
		EstoqueDto estoqueDtoResultado = mapper.mapEstoqueToEstoqueDto(estoqueResultado);
		
		return ResponseEntity.ok(estoqueDtoResultado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			EstoqueRepository.deleteById(id);			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok().build();
	}
}
