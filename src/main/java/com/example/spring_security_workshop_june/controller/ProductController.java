/**
 * 
 */
package com.example.spring_security_workshop_june.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_security_workshop_june.entity.Users;
import com.example.spring_security_workshop_june.service.UserServices;

/**
 * 
 */
@RestController
public class ProductController {

	
	@Autowired

	private UserServices service;


	@GetMapping("/hello")
	public String hello() {
		
		return "Hello World!!!!";
	}
	
	
	
	@GetMapping("/users")

	@PreAuthorize("hasRole('ADMIN')")

	public List<Users> getAllUsers() {

		return service.getAllUsers();

	}
}
