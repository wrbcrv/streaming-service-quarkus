package dev.application.service;

import java.util.List;

import dev.application.dto.UsuarioDTO;
import dev.application.dto.UsuarioResponseDTO;
import dev.application.model.Perfil;
import dev.application.model.Usuario;
import dev.application.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioResponseDTO> getAll() {
        return usuarioRepository.listAll().stream().map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Transactional
    public UsuarioResponseDTO insert(@Valid UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        Usuario usuario = new Usuario();

        usuario.setLogin(usuarioDTO.login());
        usuario.setSenha(usuarioDTO.senha());
        usuario.setPerfil(Perfil.valueOf(usuarioDTO.idPerfil()));

        usuarioRepository.persist(usuario);

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(Long usuarioId, UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        Usuario usuario = usuarioRepository.findById(usuarioId);

        if (usuario == null)
            throw new NotFoundException("Usuário não encontrado");

        usuario.setLogin(usuarioDTO.login());
        usuario.setSenha(usuarioDTO.senha());
        usuario.setPerfil(Perfil.valueOf(usuarioDTO.idPerfil()));

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public UsuarioResponseDTO findById(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId);
        if (usuario == null)
            throw new NotFoundException("Usuário não encontrado");

        return UsuarioResponseDTO.valueOf(usuario);
    }
}