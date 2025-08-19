package com.tnsif.coursemanagementmodule.service;

import java.awt.print.Pageable;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;

import com.tnsif.coursemanagementmodule.entity.Course;
import com.tnsif.coursemanagementmodule.exception.ServiceException;
public interface ICourseService {
	public List<Course> getAllCourses()throws ServiceException;

	 public Optional<Course> getCourseById(Long id)throws ServiceException;
	 
	 public Course createCourse(Course course)throws ServiceException;
	 
	 public void deleteCourse(Long id)throws ServiceException;
	 
	 public Optional<Course> updateCourse(Long id, Course updatedCourse)throws ServiceException;
	 
	 public List<Course> getCoursesByIdLessThan(long id)throws ServiceException;
	 
	 public List<Course> getCourse(String title)throws ServiceException;
	 
	 public List<Course> getCoursesByInstructorIgnoreCase(String instructor)throws ServiceException;
	 
	 public List<Course> getCourseByDescription(String description) throws ServiceException;
	 
	 public List<Course> getCourseByStartDate(Date startDate)throws ServiceException;
	 
	 public List<Course> getCoursesByStartDateBetween(Date startDateStartOfDay, Date startDateEndOfDay)throws ServiceException;
	 
	 public List<Course> getCourseByEndDate(Date endDate) throws ServiceException;
	 
	 public List<Course> findByTitleContaining(String keyword)throws ServiceException;
	 
	 public Page findAll(Pageable pageable)throws ServiceException;
	 
    public List<Course> findTopNCoursesByEndDate(int n)throws ServiceException;
	       
	 public List<Course> findAllCoursesOrderByStartDateAsc()throws ServiceException;
	 
	 public List<Course> findByInstructorAndTitleContaining(String instructor, String keyword)throws ServiceException;
	 
	 public Page findByTitleContaining(String keyword, Pageable pageable)throws ServiceException;

	 public long countByInstructor(String instructor)throws ServiceException;
}
