package com.grabduck.demo.springsecurity.services;

import com.grabduck.demo.springsecurity.persistence.entity.Token;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TokenService {

    @Transactional(readOnly = true)
    Token getByToken(String token);
}
