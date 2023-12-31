package com.mora.armazem.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mora.armazem.controller.dto.UsuarioDto;
import com.mora.armazem.entity.Usuario;
import com.mora.armazem.services.UsuarioServices;

import jakarta.validation.Valid;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioServices service;
	
		
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDto> buscar(@PathVariable Integer id) {
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(new UsuarioDto(obj));

	}
	@GetMapping
	public ResponseEntity<List<UsuarioDto>> findAll(){
		List<Usuario> list = service.findAll();
		List<UsuarioDto> listDto = list.stream().map(obj -> new UsuarioDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioDto> update(@PathVariable Integer id, @Valid @RequestBody UsuarioDto objDto){
		Usuario obj = service.update(id, objDto);
		return ResponseEntity.ok().body(new UsuarioDto(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UsuarioDto> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}	
}
