package com.mora.armazem.controller;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mora.armazem.controller.dto.PedidoDto;
import com.mora.armazem.entity.Pedido;
import com.mora.armazem.mapper.PedidoMapper;
import com.mora.armazem.repository.PedidoRepository;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {
	
	@Autowired 
	private PedidoRepository pedidoRepository;
	@Autowired
	private PedidoMapper mapper;
	
	@GetMapping
	public List<PedidoDto> getPedido(){
		List<Pedido> pedidos = pedidoRepository.findAll() ;
		return mapper.mapPedidosToPedidosDto(pedidos);
	}
	
	@PostMapping
	public PedidoDto postPedido(@RequestBody PedidoDto pedidoDto) {
		Pedido pedido = mapper.mapPedidoDtoToPedido(pedidoDto);
		
		Pedido pedidoCriado = pedidoRepository.save(pedido);
		return mapper.mapPedidoToPedidoDto(pedidoCriado);
	}
}
