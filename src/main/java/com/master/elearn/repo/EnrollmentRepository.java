package com.master.elearn.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master.elearn.entity.Enrollment;

/**
 * Repository interface for Enrollment entity.
 */
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByDeletedFalse();
}