package com.mora.armazem.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mora.armazem.controller.dto.EstoqueDto;
import com.mora.armazem.entity.Estoque;

/*
* @author Ayowole_Agbedejobi and Alessandro_Eloy
*/ 

@Mapper(componentModel = "spring")
public interface EstoqueMapper {
	 EstoqueDto mapEstoqueToEstoqueDto(Estoque estoque);
	 Estoque mapEstoqueDtoToEstoque(EstoqueDto estoqueDto);
	 List<EstoqueDto> mapEstoquesToEstoquesDto(List<Estoque> estoques);
}
