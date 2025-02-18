package com.master.elearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.elearn.entity.Course;
import com.master.elearn.entity.Enrollment;
import com.master.elearn.exception.ResourceNotFoundException;
import com.master.elearn.repo.CourseRepository;
import com.master.elearn.repo.EnrollmentRepository;



/**
 * Service class for managing Enrollment-related operations.
 */
@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    
    @Autowired
    private CourseRepository courseRepository;

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findByDeletedFalse();
    }

    public Enrollment enrollStudent(Long courseId, String studentName) {
    	Enrollment enrollment = new Enrollment();
    
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        /*
        Enrollment enrollment = Enrollment.builder()
                .course(course)
                .studentName(studentName)
                .status("Enrolled")
                .deleted(false)
                .build();
        */
    	enrollment.setCourse(course);
    	enrollment.setStudentName(studentName);
    	enrollment.setStatus("Enrolled");
    	enrollment.setDeleted(false);
        return enrollmentRepository.save(enrollment);
    }

    public void deleteEnrollment(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));
        enrollment.setDeleted(true);
        enrollmentRepository.save(enrollment);
    }
}
