package com.cuzoffservice.infrastructure.config;

import org.springframework.http.HttpStatus;

public class PasswordNotCorrectException extends UserServiceException{
    public PasswordNotCorrectException(String message){
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
