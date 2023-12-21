package dev.application.resource;

import dev.application.dto.AuthDTO;
import dev.application.dto.UsuarioResponseDTO;
import dev.application.service.HashService;
import dev.application.service.JwtService;
import dev.application.service.UsuarioService;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

  @Inject
  UsuarioService usuarioService;

  @Inject
  HashService hashService;

  @Inject
  JwtService jwtService;

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @PermitAll
  public Response login(@Valid AuthDTO authDTO) {
    try {
      String hash = hashService.getSenhaHash(authDTO.senha());

      UsuarioResponseDTO usuario = usuarioService.findByLoginAndSenha(authDTO.login(), hash);

      if (usuario == null)
        return Response.status(Status.NOT_FOUND).entity("Usuário não encontrado.").build();

      return Response.ok().header("Authorization", jwtService.generateJwt(usuario)).build();
    } catch (Exception e) {
      e.printStackTrace();
      return Response.status(Status.INTERNAL_SERVER_ERROR)
          .entity("Erro ao processar solicitação: " + e.getMessage())
          .build();
    }
  }
}