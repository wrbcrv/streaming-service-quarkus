package dev.application.service;

import java.util.List;
import java.util.stream.Collectors;

import dev.application.dto.UsuarioResponseDTO;
import dev.application.model.Usuario;
import dev.application.repository.SearchRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class SearchServiceImpl implements SearchService {
    @Inject
        SearchRepository searchRepository;
    @Override
    public List<UsuarioResponseDTO> findByLogin(String login) {
        List <Usuario>  usuario = searchRepository.search(login);
        
        if (login == null)
        throw new NotFoundException("Usuário não encontrado");


        return usuario.stream().map(e -> UsuarioResponseDTO.valueOf(e)).collect(Collectors.toList());
    }
    
}
