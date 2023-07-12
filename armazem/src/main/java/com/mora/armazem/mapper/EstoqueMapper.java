package com.mora.armazem.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mora.armazem.controller.dto.EstoqueCreate;
import com.mora.armazem.controller.dto.EstoqueDto;
import com.mora.armazem.controller.dto.EstoqueUpdate;
import com.mora.armazem.entity.Estoque;

/*
* @author Ayowole_Agbedejobi and Alessandro_Eloy
*/ 

@Mapper(componentModel = "spring")
public interface EstoqueMapper {
	List<EstoqueDto> mapEstoqueToEstoqueDto(List<Estoque> estoque);
	Estoque mapEstoqueDtoToEstoque(EstoqueDto estoqueDto);
	Estoque mapEstoqueUpdateToEstoque(EstoqueUpdate estoqueUpdate);
	Estoque mapEstoqueCreateToEstoque(EstoqueCreate estoqueCreate);
	EstoqueDto mapEstoqueToEstoqueDto(Estoque estoqueCriado);
}
