package com.grabduck.demo.springsecurity.services;

import com.grabduck.demo.springsecurity.persistence.entity.Token;
import com.grabduck.demo.springsecurity.persistence.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;

    @Override
    public Token getByToken(String token) {
        return tokenRepository.findByToken(token);
    }
}
