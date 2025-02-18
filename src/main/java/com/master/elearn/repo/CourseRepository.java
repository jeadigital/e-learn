package com.master.elearn.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master.elearn.entity.Course;

/**
 * Repository interface for Course entity.
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findByDeletedFalse();
}