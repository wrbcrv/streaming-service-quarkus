package dev.application.service;

import java.util.List;

import dev.application.dto.UsuarioResponseDTO;

public interface  SearchService  {


   List <UsuarioResponseDTO> findByLogin(String login);
}
