package com.mora.armazem.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mora.armazem.controller.dto.ProdutoCreate;
import com.mora.armazem.controller.dto.ProdutoDto;
import com.mora.armazem.controller.dto.ProdutoUpdate;
import com.mora.armazem.entity.Produto;

/*
* @author Ayowole_Agbedejobi and Alessandro_Eloy
*/

@Mapper (componentModel = "spring")
public interface ProdutoMapper {
	ProdutoDto mapProdutoToProdutoDto(Produto produto);
	Produto mapProdutoDtoToProduto(ProdutoDto produtoDto);
	List<ProdutoDto> mapProdutosToProdutosDto(List<Produto> produtos);
	Produto mapProdutoUpdateToProduto(ProdutoUpdate produtoUpdate);
	Produto mapProdutoCreateToProduto(ProdutoCreate produtoCreate);
}