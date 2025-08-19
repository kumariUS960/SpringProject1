package com.tnsif.manytomanymapping.entity.exception.repository.service;

import com.tnsif.manytomanymapping.entity.Course;
import com.tnsif.manytomanymapping.entity.Student;

public interface StudentCourseService {
	void addStudentToCourse(Student student, Course course);
}
