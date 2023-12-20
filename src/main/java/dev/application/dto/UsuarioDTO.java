package dev.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
        @NotBlank(message = "Login é obrigatório")
        String login,
        @NotBlank(message = "Senha é obrigatório")
        @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres")
        String senha,
        @NotNull(message = "Perfil é obrigatório.")
        Integer idPerfil) {
}