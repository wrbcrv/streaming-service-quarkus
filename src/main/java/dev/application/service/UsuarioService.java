package dev.application.service;

import java.util.List;

import dev.application.dto.UsuarioDTO;
import dev.application.dto.UsuarioResponseDTO;

public interface UsuarioService {
    
    List<UsuarioResponseDTO> getAll();

    UsuarioResponseDTO insert(UsuarioDTO usuarioDTO);

    UsuarioResponseDTO findById(Long id);
}