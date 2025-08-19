package com.tnsif.manytomanymapping.entity.exception.repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.tnsif.coursemanagementmodule.repository.CourseRepository;
import com.tnsif.manytomanymapping.entity.Course;

@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentCourseServiceImpl studentCourseService;

    @Override
    public Course saveCourse(Course course) {
        // No need to handle students here
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + id));
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + id));

        existingCourse.setTitle(course.getTitle()); // Assuming there's a title field
        
        // Use helper service to manage student relationships
        if (course.getStudents() != null) {
            existingCourse.getStudents().clear(); // Clear existing relationships
            course.getStudents().forEach(student -> studentCourseService.addStudentToCourse(student, existingCourse));
        }

        return courseRepository.save(existingCourse);
    }

    @Override
    public void deleteCourse(Long id) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + id));
        
        // Clear relationships before deletion
        existingCourse.getStudents().forEach(student -> student.getCourses().remove(existingCourse));
        
        courseRepository.delete(existingCourse);
    }
}
