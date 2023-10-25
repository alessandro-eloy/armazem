package com.mora.armazem.controller.dto;

import com.mora.armazem.entity.UserRole;

public record RegisterDto(String login, String senha, UserRole role) {

}
