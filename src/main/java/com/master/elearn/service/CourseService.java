package com.master.elearn.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.elearn.entity.Course;
import com.master.elearn.exception.ResourceNotFoundException;
import com.master.elearn.repo.CourseRepository;

import java.util.List;

/**
 * Service class for managing Course-related operations.
 */
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll().stream()
                .filter(course -> !course.isDeleted())
                .toList();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        return courseRepository.findById(id).map(course -> {
            course.setTitle(updatedCourse.getTitle());
            course.setDescription(updatedCourse.getDescription());
            course.setInstructor(updatedCourse.getInstructor());
            return courseRepository.save(course);
        }).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }

    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        course.setDeleted(true);
        courseRepository.save(course);
    }
}