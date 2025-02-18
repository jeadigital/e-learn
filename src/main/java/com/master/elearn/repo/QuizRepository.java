package com.master.elearn.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master.elearn.entity.Quiz;

/**
 * Repository interface for Quiz entity.
 */
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByCourseId(Long courseId);
}