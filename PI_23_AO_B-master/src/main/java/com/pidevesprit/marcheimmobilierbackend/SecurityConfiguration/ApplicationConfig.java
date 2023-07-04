package com.pidevesprit.marcheimmobilierbackend.SecurityConfiguration;

import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository repository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> repository.findByEmail(username) // Lambda expression to find a user by email
                .orElseThrow(() -> new UsernameNotFoundException("User not found")); // Throw an exception if user not found
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(); // Creating a new instance of DaoAuthenticationProvider
        authProvider.setUserDetailsService(userDetailsService()); // Setting the UserDetailsService for the authentication provider
        authProvider.setPasswordEncoder(passwordEncoder()); // Setting the password encoder for the authentication provider
        return authProvider; // Returning the authentication provider
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager(); // Returning the AuthenticationManager from the AuthenticationConfiguration
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Returning a new instance of BCryptPasswordEncoder as the PasswordEncoder
    }
}
