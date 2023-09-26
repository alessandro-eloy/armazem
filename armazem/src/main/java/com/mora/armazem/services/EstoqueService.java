package com.mora.armazem.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mora.armazem.controller.dto.EstoqueDto;
import com.mora.armazem.entity.Estoque;
import com.mora.armazem.entity.Produto;
import com.mora.armazem.entity.Usuario;
import com.mora.armazem.repository.EstoqueRepository;
import com.mora.armazem.repository.ProdutoRepository;

import jakarta.validation.Valid;

@Service
public class EstoqueService {

	@Autowired 
	private EstoqueRepository repository;
	@Autowired 
	private ProdutoRepository produtoRepository;
	@Autowired 
	private UsuarioServices userservice;
	@Autowired 
	private ProdutoServices produtoservice;
	
	
	
	public Estoque findById(Integer id) {
		Optional<Estoque> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! ID: ",+ id));
	}

	public List<Estoque> findAll() {
		return repository.findAll();
	}

	public Estoque create(@Valid EstoqueDto objDto) {
		return repository.save(newEstoque(objDto));
	}
	
	public Estoque update(@Valid Integer id, EstoqueDto objDto) {
		objDto.setId(id);
		Estoque oldObj = findById(id);
		oldObj = newEstoque(objDto);
		return repository.save(oldObj);
	}
	
	private Estoque newEstoque(EstoqueDto obj) {
		Usuario usuario = userservice.findCod(obj.getUsuario());
		Produto produto = produtoservice.findCodigo(obj.getProduto());
		
		Estoque estoque = new Estoque();
		if(obj.getId() != null) {
			estoque.setId(obj.getId());
		}
		
		estoque.setUsuario(usuario);
		estoque.setProduto(produto);
		produto.setQuantidade(produto.getQuantidade().longValue() - 1);
		produtoRepository.save(produto);
		return estoque;
	}
}
