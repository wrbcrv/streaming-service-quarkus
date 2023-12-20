package dev.application.service;

import java.util.List;
import java.util.stream.Collectors;

import dev.application.dto.UsuarioDTO;
import dev.application.dto.UsuarioResponseDTO;
import dev.application.model.Usuario;
import dev.application.repository.UsuarioRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public UsuarioResponseDTO create(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setLogin(usuarioDTO.login());
        usuario.setSenha(usuarioDTO.senha());

        usuarioRepository.persist(usuario);

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> getAll() {
        PanacheQuery<Usuario> list = usuarioRepository.findAll();

        return list.stream().map(e -> UsuarioResponseDTO.valueOf(e)).collect(Collectors.toList());
    }
}