package com.mora.armazem.controller;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mora.armazem.controller.dto.CategoriaDto;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@GetMapping
	public List<CategoriaDto> getCategoria() {
		CategoriaDto categoriaDto = new CategoriaDto();
		categoriaDto.setName("Ferramenta");
		
		return List.of(categoriaDto);
	}
}
