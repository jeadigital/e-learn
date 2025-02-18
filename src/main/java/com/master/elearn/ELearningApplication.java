package com.master.elearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Main entry point of the E-Learning application.
 */
@SpringBootApplication
@EnableWebMvc
public class ELearningApplication {
    public static void main(String[] args) {
        SpringApplication.run(ELearningApplication.class, args);
    }
    
    /**
     * Bean definition for password encoder using BCrypt.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}