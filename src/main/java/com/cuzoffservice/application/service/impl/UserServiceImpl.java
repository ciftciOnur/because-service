package com.cuzoffservice.application.service.impl;

import com.cuzoffservice.application.service.UserService;
import com.cuzoffservice.domain.model.user.User;
import com.cuzoffservice.domain.model.user.UserRepository;
import com.cuzoffservice.infrastructure.config.EmailNotFoundException;
import com.cuzoffservice.infrastructure.config.EmailNotUniqueException;
import com.cuzoffservice.infrastructure.config.PasswordNotCorrectException;
import com.cuzoffservice.interfaces.dto.ChangePasswordDto;
import com.cuzoffservice.interfaces.dto.CreateUserRequestDto;
import com.cuzoffservice.interfaces.dto.CreateUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;


	@Transactional
	@Override
	public CreateUserResponseDto createUser(CreateUserRequestDto request) {
		if(userRepository.existsByEmail(request.getEmail()))
			throw new EmailNotUniqueException("Email is used before");
		UUID userId = UUID.randomUUID();
		UUID pseudoId = UUID.randomUUID();
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		userRepository.save(User.builder()
						.email(request.getEmail())
						.password(passwordEncoder.encode(request.getPassword()))
						.userId(userId.toString())
						.pseudoId(pseudoId.toString())
						.pseudoIdExpirationDate(tomorrow)
						.name(request.getName())
						.surname(request.getSurname())
						.birthDate(request.getBirthDate())
				.build()
				);
		return CreateUserResponseDto.builder()
				.pseudoId(pseudoId.toString())
				.userId(userId.toString())
				.build();
		
	}
	@Transactional
	@Override
	public String updatePseudoId(String userId, String password) {
		User user = userRepository.findByUserId(userId);
		UUID pseudoId = UUID.randomUUID();
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		user.setPseudoId(pseudoId.toString());
		user.setPseudoIdExpirationDate(tomorrow);
		userRepository.save(user);
		return pseudoId.toString();
	}
	@Override
	public User findPseudoId(String pseudoId) {
		if(!userRepository.existsByPseudoId(pseudoId)) {
			return null;
		}
		User user = userRepository.findByPseudoId(pseudoId);
		if(user.getPseudoIdExpirationDate().isBefore(LocalDate.now())) {
			return null;
		}
		return user;
	}
	
	@Override
	public User findUserId(String userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public User findUserByEmail(String email){
		return userRepository.findByEmail(email);
	}

	@Override
	public boolean isExistUser(String email) {
		if (!userRepository.existsByEmail(email)) {
			throw new EmailNotFoundException("Email is not found");
		}
		return true;
	}

	@Transactional
	@Override
	public boolean changePassword(ChangePasswordDto changePasswordDto){
		User user=userRepository.findByEmail(changePasswordDto.getEmail());
		try {
			authenticationManager.authenticate
					(new UsernamePasswordAuthenticationToken
							(changePasswordDto.getEmail(), changePasswordDto.getOldPassword()));
		} catch (BadCredentialsException e) {
			throw new PasswordNotCorrectException("The password is not matched");
		}
		user.setPassword(passwordEncoder.encode(changePasswordDto.getNewPassword()));
		userRepository.save(user);
		return true;
	}
}
