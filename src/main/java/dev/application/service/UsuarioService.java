package dev.application.service;

import java.util.List;

import dev.application.dto.UsuarioDTO;
import dev.application.dto.UsuarioResponseDTO;
import jakarta.validation.Valid;

public interface UsuarioService {
    
    List<UsuarioResponseDTO> getAll();

    UsuarioResponseDTO insert(@Valid UsuarioDTO usuarioDTO);

    UsuarioResponseDTO update(Long usuarioId, UsuarioDTO usuarioDTO);

    UsuarioResponseDTO updateLogin(String usuarioLogin, UsuarioDTO usuarioDTO);

    UsuarioResponseDTO findById(Long usuarioId);

    UsuarioResponseDTO findByLogin(String usuarioLogin);
}