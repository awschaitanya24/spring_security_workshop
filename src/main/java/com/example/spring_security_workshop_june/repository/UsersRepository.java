/**
 * 
 */
package com.example.spring_security_workshop_june.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_security_workshop_june.entity.Users;

/**
 * 
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	
	Users findByEmail(String email);
}
