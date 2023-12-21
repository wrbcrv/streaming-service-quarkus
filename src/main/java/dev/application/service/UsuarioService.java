package dev.application.service;

import java.util.List;

import dev.application.dto.UsuarioDTO;
import dev.application.dto.UsuarioResponseDTO;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

public interface UsuarioService {

    List<UsuarioResponseDTO> getAll();

    UsuarioResponseDTO insert(@Valid UsuarioDTO usuarioDTO) throws ConstraintViolationException;

    UsuarioResponseDTO update(@Valid Long usuarioId, UsuarioDTO usuarioDTO) throws ConstraintViolationException;

    void delete(Long usuarioId);

    UsuarioResponseDTO findById(Long usuarioId);

    UsuarioResponseDTO findByLogin(String login);

    UsuarioResponseDTO findByLoginAndSenha(String login, String senha);
}