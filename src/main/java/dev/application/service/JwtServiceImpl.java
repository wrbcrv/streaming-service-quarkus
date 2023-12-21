package dev.application.service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import dev.application.dto.UsuarioResponseDTO;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JwtServiceImpl implements JwtService {

    private static final Duration EXPIRATION_TIME = Duration.ofHours(24);

    @Override
    public String generateJwt(UsuarioResponseDTO usuarioResponseDTO) {
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME);

        Set<String> roles = new HashSet<String>();

        roles.add(usuarioResponseDTO.perfil().getLabel());

        return Jwt.issuer("dev.application")
                .subject(usuarioResponseDTO.login())
                .groups(roles)
                .expiresAt(expiryDate)
                .sign();
    }
}