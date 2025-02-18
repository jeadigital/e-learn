package com.master.elearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.master.elearn.entity.User;
import com.master.elearn.exception.ResourceNotFoundException;
import com.master.elearn.repo.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing User-related operations.
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    /**
     * Registers a new user with encrypted password.
     * @param user The user details.
     * @return The saved user.
     */
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    /**
     * Retrieves a user by username.
     * @param username The username to find.
     * @return The found user or null.
     */
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    /**
     * Retrieves all users in the system.
     * @return List of all users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    /**
     * Updates an existing user's details.
     * @param id The user ID.
     * @param updatedUser The updated user details.
     * @return The updated user.
     */
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setRole(updatedUser.getRole());
            if (updatedUser.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            }
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
    
    /**
     * Soft deletes a user by ID.
     * @param id The user ID to delete.
     */
    public void softDeleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setDeleted(true); // Mark as deleted instead of actual deletion
        userRepository.save(user);
    }
}
