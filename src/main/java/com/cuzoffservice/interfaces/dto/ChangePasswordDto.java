package com.cuzoffservice.interfaces.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class ChangePasswordDto {
    @NotNull
    private String email;
    @NotNull
    private String oldPassword;
    @NotNull
    private String newPassword;
}
