package com.grabduck.demo.springsecurity.controller.handler;

import com.grabduck.demo.springsecurity.exception.TokenNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class TokenExceptionHandler {

    @ExceptionHandler(value = TokenNotFoundException.class)
    private String tokenNotFounException(TokenNotFoundException e) {
        return String.format("{\"error\":\"%s\"}", e.getMessage());
    }
}
