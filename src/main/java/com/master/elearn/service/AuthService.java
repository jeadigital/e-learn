package com.master.elearn.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.master.elearn.entity.User;
import com.master.elearn.exception.ResourceNotFoundException;
import com.master.elearn.repo.UserRepository;
import com.master.elearn.security.JwtUtil;

import java.util.Optional;

/**
 * Service class for managing authentication and login operations.
 */
@Service
public class AuthService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    /**
     * Handles user authentication and generates JWT token.
     * @param username The username.
     * @param password The password.
     * @return The generated JWT token.
     */
    public String authenticateUser(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent() && passwordEncoder.matches(password, optionalUser.get().getPassword())) {
            return jwtUtil.generateToken(username);
        }
        throw new ResourceNotFoundException("Invalid username or password");
    }
}