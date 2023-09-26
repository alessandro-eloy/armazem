package com.mora.armazem.services;

/*
 * 
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mora.armazem.controller.dto.ProdutoDto;
import com.mora.armazem.entity.Produto;
import com.mora.armazem.repository.ProdutoRepository;
import com.mora.armazem.services.exception.DataIntegrityViolationException;
import com.mora.armazem.services.exception.ObjectnotFoundException;

import jakarta.validation.Valid;


@Service
public class ProdutoServices {
	
	@Autowired
	private ProdutoRepository repository;
	
	public Produto findCodigo(String codigo) {
		Optional<Produto> obj = repository.findByCodigo(codigo);
		return obj.orElseThrow(()-> new ObjectnotFoundException("Objeto não encontrado! Código: " + codigo));
	}
	
	public Produto findById(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto create(ProdutoDto objDto) {
		objDto.setId(null);
		validaPorcodigoEName(objDto);
		Produto newObj = new Produto(objDto);
		return repository.save(newObj);
	}
	
	public Produto update(Integer id, @Valid ProdutoDto objDto) {
		objDto.setId(id);
		Produto oldObj = findById(id);
		 validaPorcodigoEName(objDto);
		 oldObj = new Produto(objDto);
		 return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Produto obj = findById(id);
		if(obj.getEstoques().size() > 0) {
			throw new DataIntegrityViolationException("Produto possui lançamentos no estoque!");
		}
		repository.deleteById(id);
	}

	private void validaPorcodigoEName(ProdutoDto objDto) {
		Optional<Produto> obj = repository.findByCodigo(objDto.getCodigo());
		if(obj.isPresent()&& obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("Código de Produto já cadastrado no sistema!");
		}
		
		obj = repository.findByNome(objDto.getNome());
		if(obj.isPresent()&& obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("Nome já cadastrado no sistema!");
		}
	}

}
