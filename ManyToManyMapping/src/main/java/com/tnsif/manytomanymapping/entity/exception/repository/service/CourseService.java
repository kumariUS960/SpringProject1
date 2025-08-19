package com.tnsif.manytomanymapping.entity.exception.repository.service;

import com.tnsif.manytomanymapping.entity.Course;
import java.util.List;
public interface CourseService {
	Course saveCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course updateCourse(Long id, Course course);
    void deleteCourse(Long id);
}
