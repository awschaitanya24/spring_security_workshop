/**
 * 
 */
package com.example.spring_security_workshop_june.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.spring_security_workshop_june.dto.LoginDto;
import com.example.spring_security_workshop_june.dto.RegisterDto;
import com.example.spring_security_workshop_june.entity.Users;
import com.example.spring_security_workshop_june.repository.UsersRepository;

/**
 * 
 */
@Service
public class AuthService {

	@Autowired
	private UsersRepository repo;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	public Users register(RegisterDto register) {

		Users user = new Users();
		user.setName(register.getName());
		user.setEmail(register.getEmail());
		user.setPassword(encoder.encode(register.getPassword()));
		user.setRole(register.getRole());
		
		return repo.save(user);

	}
	
	
	public Users login(LoginDto input) {
		Users user = repo.findByEmail(input.getEmail());
		if (user != null && encoder.matches(input.getPassword(), user.getPassword())) {
			authenticationManager
			.authenticate(new UsernamePasswordAuthenticationToken(

							input.getEmail(), input.getPassword()));

			return user;

		}

		return null;

	}
}
