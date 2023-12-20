package dev.application.resource;

import java.util.List;
import java.util.NoSuchElementException;

import dev.application.dto.UsuarioDTO;
import dev.application.dto.UsuarioResponseDTO;
import dev.application.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @GET
    public Response getAll() {
        try {
            List<UsuarioResponseDTO> usuarios = usuarioService.getAll();
            return Response.ok(usuarios).build();
        } catch (Exception e) {
            return Response.status(500).entity("Erro ao obter todos os usuários: " + e.getMessage()).build();
        }
    }

    @POST
    public Response insert(UsuarioDTO dto) {
        try {
            UsuarioResponseDTO usuario = usuarioService.insert(dto);
            return Response.ok(usuario).build();
        } catch (Exception e) {
            return Response.status(500).entity("Erro ao criar usuário").build();
        }
    }

    @PATCH
    @Path("/{usuarioId}")
    public Response update(@PathParam("usuarioId") Long usuarioId, UsuarioDTO usuarioDTO) {
        try {
            UsuarioResponseDTO usuario = usuarioService.update(usuarioId, usuarioDTO);
            return Response.ok(usuario).build();
        } catch (Exception e) {
            return Response.status(500).entity("Erro ao atualizar usuário").build();
        }
    }

    @GET
    @Path("/{usuarioId}")
    public Response findById(@PathParam("usuarioId") Long usuarioId) {
        try {
            UsuarioResponseDTO usuario = usuarioService.findById(usuarioId);
            return Response.ok(usuario).build();
        } catch (NoSuchElementException e) {
            return Response.status(404).entity("Usuário não encontrado").build();
        } catch (Exception e) {
            return Response.status(500).entity("Erro ao buscar usuário por ID: " + e.getMessage()).build();
        }
    }
}