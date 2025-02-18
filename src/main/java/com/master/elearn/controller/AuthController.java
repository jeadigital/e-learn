package com.master.elearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.master.elearn.service.AuthService;



/**
 * REST Controller for Authentication.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    /**
     * Authenticates a user and generates JWT token.
     * @param username The username.
     * @param password The password.
     * @return The JWT token.
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok(authService.authenticateUser(username, password));
    }
}
