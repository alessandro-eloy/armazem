package com.mora.armazem.mapper;

/*
* @author Ayowole_Agbedejobi and Alessandro_Eloy
*/

import java.util.List;

import org.mapstruct.Mapper;

import com.mora.armazem.controller.dto.UsuarioDto;
import com.mora.armazem.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	UsuarioDto mapUsuarioToUsuarioDto(Usuario usuario);
	Usuario mapUsuarioDtoToUsuario(UsuarioDto usuarioDto);
	List<UsuarioDto> mapUsuariosToUsuariosDto(List<Usuario> usuarios);
}