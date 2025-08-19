package com.tnsif.manytomanymapping.entity.exception.repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;
import com.tnsif.manytomanymapping.entity.Student;
import com.tnsif.manytomanymapping.entity.exception.StudentNotFoundException;
import com.tnsif.manytomanymapping.entity.exception.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	 @Autowired
	 
	    @Lazy
	    private StudentRepository studentRepository;

	    @Autowired
	    private StudentCourseServiceImpl studentCourseService;

	    @Override
	    public Student saveStudent1(Student student) {
	        // No need to handle courses here
	        return studentRepository.save(student);
	    }

	    @Override
	    public List<Student> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    @Override
	    public Student getStudentById(Long id) {
	        return studentRepository.findById(id)
	                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
	    }

	    @Override
	    public Student updateStudent1(Long id, Student student) {
	        Student existingStudent = studentRepository.findById(id)
	                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
	        
	        existingStudent.setName(student.getName()); // Assuming there's a name field
	        
	        // Use helper service to manage course relationships
	        if (student.getCourses() != null) {
	            existingStudent.getCourses().clear(); // Clear existing relationships
	            student.getCourses().forEach(course -> studentCourseService.addStudentToCourse(existingStudent, course));
	        }
	        
	        return studentRepository.save(existingStudent);
	    }

	    @Override
	    public void deleteStudent(Long id) {
	        Student existingStudent = studentRepository.findById(id)
	                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
	        
	        // Clear relationships before deletion
	        existingStudent.getCourses().forEach(course -> course.getStudents().remove(existingStudent));
	        
	        studentRepository.delete(existingStudent);
	    }

		@Override
		public Student saveStudent(Student student) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Student updateStudent(Long id, Student student) {
			// TODO Auto-generated method stub
			return null;
		}
}
