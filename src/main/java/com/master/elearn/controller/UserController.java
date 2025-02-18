package com.master.elearn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.elearn.entity.User;
import com.master.elearn.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

/**
 * REST Controller for User Management.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    /**
     * Registers a new user.
     * @param user User details.
     * @return ResponseEntity with created user.
     */
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    /**
     * Retrieves all users.
     * @return List of users.
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * Retrieves a user by username.
     * @param username The username to find.
     * @return The found user.
     */
    @GetMapping("/{username}")
    public ResponseEntity<Optional<User>> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    /**
     * Updates a user's details.
     * @param id The user ID.
     * @param updatedUser The updated user details.
     * @return The updated user.
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return ResponseEntity.ok(userService.updateUser(id, updatedUser));
    }

    /**
     * Soft deletes a user by ID.
     * @param id The user ID to delete.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.softDeleteUser(id);
        return ResponseEntity.ok("User soft deleted successfully.");
    }
}
