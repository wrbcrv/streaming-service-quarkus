package dev.application.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HashServiceImpl implements HashService {

    private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
    private static final int ITERATION_COUNT = 405;
    private static final int KEY_LENGTH = 512;

    @Override
    public String getSenhaHash(String senha) {
        if (senha == null)
            throw new IllegalArgumentException("A senha não pode ser nula.");

        byte[] salt = generateRandomSalt();

        try {
            byte[] result = SecretKeyFactory
                    .getInstance(ALGORITHM)
                    .generateSecret(new PBEKeySpec(senha.toCharArray(), salt, ITERATION_COUNT, KEY_LENGTH))
                    .getEncoded();

            byte[] combined = new byte[result.length + salt.length];
            System.arraycopy(salt, 0, combined, 0, salt.length);
            System.arraycopy(result, 0, combined, salt.length, result.length);

            return Base64.getEncoder().encodeToString(combined);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] generateRandomSalt() {
        SecureRandom secureRandom;
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao inicializar.", e);
        }

        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;
    }
}