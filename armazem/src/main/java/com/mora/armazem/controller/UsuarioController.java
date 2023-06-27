package com.mora.armazem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mora.armazem.controller.dto.UsuarioDto;
import com.mora.armazem.entity.Usuario;
import com.mora.armazem.repository.UsuarioRepository;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<UsuarioDto> getUsuario(){
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setLogin("alessandro.eloy");
		usuarioDto.setNome("Alessandro Eloy");
		usuarioDto.setSenha("teste123");
		return List.of(usuarioDto);
	}
	
	@PostMapping
	public void postUsuario(@RequestBody UsuarioDto usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setId(Long.valueOf(usuarioDto.getId()));
		usuario.setNome(usuario.getNome());
		usuario.setSenha(usuario.getSenha());
		usuario.setLogin(usuario.getLogin());
		
		usuarioRepository.save(usuario);
	}
	
}
