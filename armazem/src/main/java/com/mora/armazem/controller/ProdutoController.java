package com.mora.armazem.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mora.armazem.controller.dto.ProdutoDto;
import com.mora.armazem.entity.Produto;
import com.mora.armazem.services.ProdutoServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoServices service;
	
		
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<ProdutoDto> buscar(@PathVariable String codigo) {
		Produto obj = service.findCodigo(codigo);
		return ResponseEntity.ok().body(new ProdutoDto(obj));

	}
	@GetMapping
	public ResponseEntity<List<ProdutoDto>> findAll(){
		List<Produto> list = service.findAll();
		List<ProdutoDto> listDto = list.stream().map(obj -> new ProdutoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDto> create(@Valid @RequestBody ProdutoDto objDto){
		Produto newObj = service.create(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProdutoDto> update(@PathVariable Integer id, @Valid @RequestBody ProdutoDto objDto){
		Produto obj = service.update(id, objDto);
		return ResponseEntity.ok().body(new ProdutoDto(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ProdutoDto> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}	
}