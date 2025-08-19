package com.tnsif.manytomanymapping.entity.exception.repository.service;

import com.tnsif.manytomanymapping.entity.Student;
import java.util.List;
public interface StudentService {
	Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
	Student saveStudent1(Student student);
	Student updateStudent1(Long id, Student student);
}
