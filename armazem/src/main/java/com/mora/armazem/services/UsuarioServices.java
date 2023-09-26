package com.mora.armazem.services;

/*
 * 
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mora.armazem.controller.dto.UsuarioDto;
import com.mora.armazem.entity.Usuario;
import com.mora.armazem.repository.UsuarioRepository;
import com.mora.armazem.services.exception.DataIntegrityViolationException;
import com.mora.armazem.services.exception.ObjectnotFoundException;

import jakarta.validation.Valid;


@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario findCod(Long cod) {
		Optional<Usuario> obj = repository.findByCod(cod);
		return obj.orElseThrow(()-> new ObjectnotFoundException("Objeto não encontrado! Código: " + cod));
	}
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario create(UsuarioDto objDto) {
		objDto.setId(null);
		validaPorCodEName(objDto);
		Usuario newObj = new Usuario(objDto);
		return repository.save(newObj);
	}
	
	public Usuario update(Integer id, @Valid UsuarioDto objDto) {
		objDto.setId(id);
		Usuario oldObj = findById(id);
		 validaPorCodEName(objDto);
		 oldObj = new Usuario(objDto);
		 return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Usuario obj = findById(id);
		if(obj.getEstoques().size() > 0) {
			throw new DataIntegrityViolationException("Usuario possui lançamentos no estoque!");
		}
		repository.deleteById(id);
	}

	private void validaPorCodEName(UsuarioDto objDto) {
		Optional<Usuario> obj = repository.findByCod(objDto.getCod());
		if(obj.isPresent()&& obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("Código de usuario já cadastrado no sistema!");
		}
		
		obj = repository.findByNome(objDto.getNome());
		if(obj.isPresent()&& obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("Nome já cadastrado no sistema!");
		}
	}

}
