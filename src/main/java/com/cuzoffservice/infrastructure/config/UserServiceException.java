package com.cuzoffservice.infrastructure.config;

import org.springframework.http.HttpStatus;

public class UserServiceException extends RuntimeException {

    private int code;

    public UserServiceException() {
    }

    public UserServiceException(String message) {
        super(message);
        this.code = 500;
    }

    public UserServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public UserServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.code = httpStatus.value();
    }

    public int getCode() {
        return code;
    }
}

