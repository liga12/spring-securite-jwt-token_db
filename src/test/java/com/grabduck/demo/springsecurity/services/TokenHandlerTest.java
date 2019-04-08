package com.grabduck.demo.springsecurity.services;

import com.grabduck.demo.springsecurity.security.TokenHandler;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Optional;

public class TokenHandlerTest {
    @Test
    public void generateToken() {
        TokenHandler tokenHandler = new TokenHandler();
        String token = tokenHandler.generateAccessToken(1L, LocalDateTime.now().plusDays(14));
        System.out.println(token);

        Optional<Long> id = tokenHandler.extractUserId(token);
        System.out.println(id.get().toString());
    }

}