package com.cuzoffservice.interfaces.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class CreateUserRequestDto {
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String name;
	@NotNull
	private String surname;
	@NotNull
	private LocalDate birthDate;

}
