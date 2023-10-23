package com.mora.armazem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mora.armazem.controller.dto.AuthenticationDto;
import com.mora.armazem.controller.dto.RegisterDto;
import com.mora.armazem.repository.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired UsuarioRepository repository;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDto data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/add")
	public ResponseEntity add(@RequestBody @Valid RegisterDto data) {
		if(this.repository.findByNome(data.login())!=null) return ResponseEntity.badRequest().build();
		
	}
}
