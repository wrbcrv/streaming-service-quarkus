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

    @Inject
    HashServiceImpl hashServiceImpl;

    @Override
    public List<UsuarioResponseDTO> getAll() {
        return usuarioRepository.listAll().stream().map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Transactional
    public UsuarioResponseDTO insert(@Valid UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        Usuario usuario = new Usuario();

        usuario.setLogin(usuarioDTO.login());
        usuario.setSenha(hashServiceImpl.getSenhaHash(usuarioDTO.senha()));
        usuario.setPerfil(Perfil.valueOf(usuarioDTO.idPerfil()));

        usuarioRepository.persist(usuario);

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(@Valid Long usuarioId, UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        Usuario usuario = usuarioRepository.findById(usuarioId);

        if (usuario == null)
            throw new NotFoundException("Usuário não encontrado");

        usuario.setLogin(usuarioDTO.login());
        usuario.setSenha(hashServiceImpl.getSenhaHash(usuarioDTO.senha()));
        usuario.setPerfil(Perfil.valueOf(usuarioDTO.idPerfil()));

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public void delete(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    @Override
    public UsuarioResponseDTO findById(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId);
        
        if (usuario == null)
            throw new NotFoundException("Usuário não encontrado");

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public UsuarioResponseDTO findByLogin(String login) {
        Usuario usuario = usuarioRepository.findByLogin(login);

        if (usuario == null)
            throw new NotFoundException("Usuário não encontrado");

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha) {
        Usuario usuario = usuarioRepository.findByLoginAndSenha(login, senha);

        if (usuario == null)
            throw new NotFoundException("Usuário não encontrado");

        return UsuarioResponseDTO.valueOf(usuario);
    }
}