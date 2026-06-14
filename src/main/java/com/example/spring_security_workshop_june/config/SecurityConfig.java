/**
 * 
 */
package com.example.spring_security_workshop_june.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.spring_security_workshop_june.filter.JWTFilter;


/**
 * 
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	private final JWTFilter Jwtfilter;
	@Autowired
	private AuthenticationProvider authProvider;

	SecurityConfig(JWTFilter Jwtfilter) {
		this.Jwtfilter = Jwtfilter;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {

		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests((auth) -> auth
				.requestMatchers("/register").permitAll()
				.requestMatchers("/login").permitAll()
				.anyRequest().authenticated())
				.authenticationProvider(authProvider)
				.sessionManagement(session -> session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(Jwtfilter, UsernamePasswordAuthenticationFilter.class);
				//.httpBasic(Customizer.withDefaults())
				//.formLogin(Customizer.withDefaults())
				//.logout(logout -> logout
				//.logoutSuccessUrl("/login")
				//.invalidateHttpSession(true)
				//.deleteCookies("JSESSIONID"));
		
		return http.build();
	}

	/*@Bean
	public InMemoryUserDetailsManager userDetailsService() {

		UserDetails user = User.withDefaultPasswordEncoder()
				.username("Tech")
				.password("Tech@mplifier5")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);

	}*/
}
