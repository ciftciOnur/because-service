package com.cuzoffservice.infrastructure.config;

import org.springframework.http.HttpStatus;

public class EmailNotFoundException extends UserServiceException{
    public EmailNotFoundException(String message){
        super(message, HttpStatus.NOT_FOUND);
    }
}
