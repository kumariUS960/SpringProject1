package com.tnsif.coursemanagementmodule.service;

import java.awt.print.Pageable;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tnsif.coursemanagementmodule.entity.Course;
import com.tnsif.coursemanagementmodule.exception.ServiceException;
import com.tnsif.coursemanagementmodule.repository.CourseRepository;

@Service
public class CourseService implements ICourseService{
	@Autowired
	
	private final CourseRepository
	courseRepository;
	
	//Constructor injection for CourseRepository dependency.
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    //Retrieves all courses from the database.
    public List<Course> getAllCourses()throws ServiceException 
    {
            return courseRepository.findAll();  
    }

    //Retrieves a course by its ID.
    public Optional<Course> getCourseById(Long id)throws ServiceException 
    {
            return courseRepository.findById(id);
     }
    
    //Retrieves a courses by its id
    public List<Course> getCoursesByIdLessThan(long id)throws ServiceException 
    {
        return courseRepository.retrieveByIdLessThan(id);
    }    
    //Retrieves a course by its title
    public List<Course> getCourse(String title)throws ServiceException 
    {
		return courseRepository.findByTitle(title);
	}
    
    //Retrieves a courses by instructor
    public List<Course> getCoursesByInstructorIgnoreCase(String instructor)throws ServiceException 
    {
        return courseRepository.findByInstructorIgnoreCase(instructor);
    }
    //Retrieves a course by its description
    public List<Course> getCourseByDescription(String description) throws ServiceException
    {
    	return courseRepository.findByDescription(description);
    }
    //Retrieves a course by its startDate
    public List<Course> getCourseByStartDateCourses(Date startDate)throws ServiceException 
    {
        return courseRepository.findByStartDate(startDate);
    }
    //Retrieves a course by its startDate with range
    public List<Course> getCoursesByStartDateBetweenCourses(Date startDateStartOfDay, Date startDateEndOfDay)throws ServiceException 
    {
        return courseRepository.retrieveByStartDateBetween(startDateStartOfDay, startDateEndOfDay);
    }
    //Retrieves a course by its endDate
    public List<Course> getCourseByEndDateCourses(Date endDate) throws ServiceException
    {
        return courseRepository.findByEndDate(endDate);
    }
    //Retrieves a course by its title containing a keyword
    public List<Course> findByTitleContaining(String keyword) throws ServiceException
    {
        return courseRepository.findByTitleContaining(keyword);
    }
    //Retrieves a courses by its pagination 
    public Page findAllPage(Pageable pageable) throws ServiceException
    { 
        return courseRepository.findAll(pageable);
    }
    //Retrieves a courses by its limits in descending order
    @Override
    public List<Course> findTopNCoursesByEndDate(int n)throws ServiceException {
       
    	 Pageable pageable = (Pageable) PageRequest.of(0, n);
         return courseRepository.findTopNByOrderByEndDateDesc(pageable);
    }
    //Retrieves a courses by its limits in ascending order
    public List<Course> findAllCoursesOrderByStartDateAsc()throws ServiceException 
    {
       
        return courseRepository.findAllByOrderByStartDateAsc();
    }
    // Find courses by instructor and title containing a keyword
    public List<Course> findByInstructorAndTitleContaining(String instructor, String keyword) throws ServiceException
    {
        return courseRepository.findByInstructorAndTitleContaining(instructor, keyword);
    }

    // Find courses with pagination and sorting by title
    public Page findByTitleContaining(String keyword, Pageable pageable) throws ServiceException
    {
        return courseRepository.findByTitleContaining(keyword, pageable);
    }

    // Count courses by instructor
    public long countByInstructor(String instructor) throws ServiceException
    {
        return courseRepository.countByInstructor(instructor);
    }
    //Creates a new course.
    public Course createCourse1(Course course)throws ServiceException 
    {
            return courseRepository.save(course);
    }

    //Deletes a course by its ID.
    public void deleteCourse(Long id)throws ServiceException 
    {
            courseRepository.deleteById(id);
    }

    //Updates a course with the given ID.
    public Optional<Course> updateCourse1(Long id, Course updatedCourse)throws ServiceException 
    {
            Optional<Course> optionalCourse = courseRepository.findById(id);
            if (optionalCourse.isPresent()) {
                Course course = optionalCourse.get();
                // Update course attributes
                course.setTitle(updatedCourse.getTitle());
                course.setDescription(updatedCourse.getDescription());
                course.setStartDate(updatedCourse.getStartDate());
                course.setEndDate(updatedCourse.getEndDate());
                course.setInstructor(updatedCourse.getInstructor());
                // Save the updated course
                return Optional.of(courseRepository.save(course));
            } else {
                return Optional.empty(); // Course with the given ID not found
            }   
    }

	@Override
	public Course createCourse(Course course) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Course> updateCourse(Long id, Course updatedCourse) throws ServiceException {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Course> getCourseByStartDate(Date startDate) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getCoursesByStartDateBetween(Date startDateStartOfDay, Date startDateEndOfDay)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getCourseByEndDate(Date endDate) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page findAll(Pageable pageable) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
}
