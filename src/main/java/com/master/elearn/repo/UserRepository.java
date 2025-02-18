package com.master.elearn.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.master.elearn.entity.User;

import java.util.Optional;

/**
 * Repository interface for User entity.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}