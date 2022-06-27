package com.cuzoffservice.interfaces.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateUserResponseDto {
	
	private String userId;
	private String pseudoId;

}
