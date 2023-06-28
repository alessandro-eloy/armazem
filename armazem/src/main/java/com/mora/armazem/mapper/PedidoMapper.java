package com.mora.armazem.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mora.armazem.controller.dto.PedidoDto;
import com.mora.armazem.entity.Pedido;

/*
* @author Ayowole_Agbedejobi and Alessandro_Eloy
*/ 

@Mapper(componentModel = "spring")
public interface PedidoMapper {
	 PedidoDto mapPedidoToPedidoDto(Pedido pedido);
	 Pedido mapPedidoDtoToPedido(PedidoDto pedidoDto);
	 List<PedidoDto> mapPedidosToPedidosDto(List<Pedido> pedidos);
}
