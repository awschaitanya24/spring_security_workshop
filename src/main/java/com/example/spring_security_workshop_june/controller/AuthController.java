/**
 * 
 */
package com.example.spring_security_workshop_june.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_security_workshop_june.dto.LoginDto;
import com.example.spring_security_workshop_june.dto.RegisterDto;
import com.example.spring_security_workshop_june.entity.Users;
import com.example.spring_security_workshop_june.service.AuthService;
import com.example.spring_security_workshop_june.service.JwtService;

/**
 * 
 */
@RestController
public class AuthController {

	@Autowired
	private AuthService  authService;
	
	@PostMapping("/register")

	public Users register(@RequestBody RegisterDto register) {
		return authService.register(register);
	}
	
	@Autowired
	private JwtService jwtService;

	@PostMapping("/login")
	public String login(@RequestBody LoginDto loginDto) {

		Users user = authService.login(loginDto);

		if (user == null) {

			return "Invalid credentials";

		} else {

			return jwtService.generateToken(user);

		}

	}
}
