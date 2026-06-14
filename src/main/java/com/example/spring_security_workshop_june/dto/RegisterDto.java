/**
 * 
 */
package com.example.spring_security_workshop_june.dto;

/**
 * 
 */
public class RegisterDto {

	private String name;

	private String email;

	private String password;

	private String role;

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public final void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public final String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public final void setRole(String role) {
		this.role = role;
	}
}
