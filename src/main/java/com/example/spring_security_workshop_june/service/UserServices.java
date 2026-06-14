/**
 * 
 */
package com.example.spring_security_workshop_june.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_security_workshop_june.entity.Users;
import com.example.spring_security_workshop_june.repository.UsersRepository;

/**
 * 
 */
@Service
public class UserServices {

	@Autowired

	public UsersRepository repo;

	public List<Users> getAllUsers() {

		return repo.findAll();

	}

	public Users getUserById(Long id) {

		return repo.findById(id).orElse(null);

	}
}
