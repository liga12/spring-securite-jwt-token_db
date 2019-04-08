package com.grabduck.demo.springsecurity.persistence.repository;

import com.grabduck.demo.springsecurity.persistence.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {

    Token findByToken(String token);
}
