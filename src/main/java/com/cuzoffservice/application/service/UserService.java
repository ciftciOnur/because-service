package com.cuzoffservice.application.service;


import com.cuzoffservice.domain.model.user.User;
import com.cuzoffservice.interfaces.dto.ChangePasswordDto;
import com.cuzoffservice.interfaces.dto.CreateUserRequestDto;
import com.cuzoffservice.interfaces.dto.CreateUserResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
	@Transactional
	CreateUserResponseDto createUser(CreateUserRequestDto request);

	String updatePseudoId(String email);

	User findPseudoId(String pseudoId);

	User findUserId(String userId);

	User findUserByEmail(String email);

	boolean isExistUser(String email);

	@Transactional
	boolean changePassword(ChangePasswordDto changePasswordDto);
}
