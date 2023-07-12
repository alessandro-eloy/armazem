package com.mora.armazem.controller;

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

import com.mora.armazem.controller.dto.UsuarioDto;
import com.mora.armazem.controller.dto.UsuarioUpdate;
import com.mora.armazem.entity.Usuario;
import com.mora.armazem.mapper.UsuarioMapper;
import com.mora.armazem.repository.UsuarioRepository;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private UsuarioMapper mapper;
	
	@GetMapping
	public List<UsuarioDto> getUsuario(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		return mapper.mapUsuariosToUsuariosDto(usuarios);
		
	}
	
	@GetMapping("/{id}")
	public Usuario findById(@PathVariable Long id) {
		return usuarioRepository.findById(id).orElse(null);

	}
	
	@PostMapping
	public UsuarioDto postUsuario(@RequestBody UsuarioDto usuarioDto) {
		Usuario usuario = mapper.mapUsuarioDtoToUsuario(usuarioDto);
		
		Usuario usuarioCriado = usuarioRepository.save(usuario);
		
		return mapper.mapUsuarioToUsuarioDto(usuarioCriado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDto> update(@PathVariable Long id, @RequestBody UsuarioUpdate usuarioUpdate) {
		if ((id == null || usuarioUpdate.getId() == null) || id != usuarioUpdate.getId()) {
			return ResponseEntity.badRequest().build();
		}
		
		Usuario usuario = mapper.mapUsuarioUpdateToUsuario(usuarioUpdate);
		
		Usuario usuarioResultado = usuarioRepository.save(usuario);
		
		UsuarioDto usuarioDtoResultado = mapper.mapUsuarioToUsuarioDto(usuarioResultado);
		
		return ResponseEntity.ok(usuarioDtoResultado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			usuarioRepository.deleteById(id);			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok().build();
	}
	
}
