package com.grabduck.demo.springsecurity.exception;

public class TokenNotFoundException extends RuntimeException {

    public TokenNotFoundException(){
        super("Token not found");
    }
}
