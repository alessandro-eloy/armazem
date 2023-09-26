package com.mora.armazem.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mora.armazem.controller.dto.EstoqueDto;
import com.mora.armazem.entity.Estoque;
import com.mora.armazem.services.EstoqueService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/estoque")
public class EstoqueController {

	@Autowired
	private EstoqueService service;


	@GetMapping(value = "/{id}")
	public ResponseEntity<EstoqueDto> findById(@PathVariable Integer id) {
		Estoque obj = service.findById(id);
		return ResponseEntity.ok().body(new EstoqueDto(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<EstoqueDto>> findAll(){
		List<Estoque> list = service.findAll();
		List<EstoqueDto> listDto = list.stream().map(obj -> new EstoqueDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listDto);
		
	}
	
	@PostMapping
	public ResponseEntity<EstoqueDto> create(@Valid @RequestBody EstoqueDto objDto){
		Estoque obj = service.create(objDto);
		
		
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequestUri().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EstoqueDto> update(@Valid @PathVariable Integer id, @RequestBody EstoqueDto objDto){
		Estoque newObj = service.update(id, objDto);
		return ResponseEntity.ok(new EstoqueDto(newObj));
	}

}