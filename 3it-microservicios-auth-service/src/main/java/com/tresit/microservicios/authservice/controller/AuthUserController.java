package com.tresit.microservicios.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tresit.microservicios.authservice.dto.AuthUserDto;
import com.tresit.microservicios.authservice.dto.TokenDto;
import com.tresit.microservicios.authservice.entity.AuthUser;
import com.tresit.microservicios.authservice.service.AuthUserService;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

	@Autowired
	AuthUserService authUserService;
	
	@PostMapping("/login")
	public ResponseEntity<TokenDto> login(@RequestBody AuthUserDto dto){
		TokenDto tokenDto = authUserService.login(dto);
		if (tokenDto == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(tokenDto);
	}

	@PostMapping("/validate")
	public ResponseEntity<TokenDto> validate(@RequestParam String token){
		TokenDto tokenDto = authUserService.validate(token);
		if(tokenDto == null) {
			//return ResponseEntity.badRequest().build();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.ok(tokenDto);
	}

	@PostMapping("/create")
	public ResponseEntity<AuthUser> create(@RequestBody AuthUserDto dto){
		AuthUser authUser = authUserService.save(dto);
		if(authUser == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(authUser);
	}

}
