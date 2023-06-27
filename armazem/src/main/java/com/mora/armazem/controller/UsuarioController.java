package com.mora.armazem.controller;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mora.armazem.controller.dto.UsuarioDto;
import com.mora.armazem.entity.Usuario;
import com.mora.armazem.mapper.UsuarioMapper;
import com.mora.armazem.repository.UsuarioRepository;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

@RestController
@RequestMapping("/usuarios")
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
	
	@PostMapping
	public UsuarioDto postUsuario(@RequestBody UsuarioDto usuarioDto) {
		Usuario usuario = mapper.mapUsuarioDtoToUsuario(usuarioDto);
		
		Usuario usuarioCriado = usuarioRepository.save(usuario);
		
		return mapper.mapUsuarioToUsuarioDto(usuarioCriado);
	}
	
}
