package com.cuzoffservice.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResponseDto {
    private final String jwttoken;
}
