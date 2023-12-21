package dev.application.dto;

import dev.application.model.Usuario;

public record UsuarioResponseDTO(
        Long id,
        String login,
        String senha) {

    public static UsuarioResponseDTO valueOf(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getSenha());
    }
}