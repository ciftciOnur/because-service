package com.cuzoffservice.interfaces.controller;

import com.cuzoffservice.application.service.UserService;
import com.cuzoffservice.interfaces.dto.ChangePasswordDto;
import com.cuzoffservice.interfaces.dto.PseudoIdUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
    UserService userService;

    @RequestMapping(value = "/update-pseudoid", method = RequestMethod.PUT)
    ResponseEntity<String> updatePseudoId(@RequestBody PseudoIdUpdateDto pseudoIdUpdateDTO) {
        return new ResponseEntity<String>(userService
        		.updatePseudoId(pseudoIdUpdateDTO.getUserId(), pseudoIdUpdateDTO.getPassword()), HttpStatus.OK);
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.PUT)
    ResponseEntity<Boolean> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        return new ResponseEntity<Boolean>(userService.changePassword(changePasswordDto),HttpStatus.OK);
    }
    

}
