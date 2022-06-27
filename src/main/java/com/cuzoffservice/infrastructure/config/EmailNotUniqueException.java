package com.cuzoffservice.infrastructure.config;

import org.springframework.http.HttpStatus;

public class EmailNotUniqueException extends UserServiceException{

    public EmailNotUniqueException(String message){
        super(message,HttpStatus.CONFLICT);
    }
}
