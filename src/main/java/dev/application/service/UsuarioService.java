package dev.application.service;

import java.util.List;

import dev.application.dto.UsuarioDTO;
import dev.application.dto.UsuarioResponseDTO;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

public interface UsuarioService {
    
    List<UsuarioResponseDTO> getAll();

    UsuarioResponseDTO insert(@Valid UsuarioDTO usuarioDTO) throws ConstraintViolationException;

    UsuarioResponseDTO update(Long usuarioId, UsuarioDTO usuarioDTO);

    UsuarioResponseDTO findById(Long usuarioId);
}