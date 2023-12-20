package dev.application.dto;

import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(
        @NotNull(message = "Login é obrigatório")
        String login,
        @NotNull(message = "Senha é obrigatório")
        String senha) {
}