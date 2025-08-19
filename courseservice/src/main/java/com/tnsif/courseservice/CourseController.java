package com.tnsif.courseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class CourseController {
	 @Autowired
	    private CourseService courseService;

	    @GetMapping("/courses")
	    public List<Course> getAllCourses() 
	    {
	        return courseService.getAllCourses();
	    }

	    @GetMapping("/courses/{id}")
	    public Course getCourseById(@PathVariable Long id) 
	    {
	        return courseService.getCourseById(id);
	    }

	    @PostMapping("/courses")
	    public Course createCourse(@RequestBody Course course) 
	    {
	        return courseService.saveCourse(course);
	    }

	    @PutMapping("/courses/{id}")
	    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) 
	    {
	        return courseService.updateCourse(id, course);
	    }

	    @DeleteMapping("/courses/{id}")
	    public void deleteCourse(@PathVariable Long id) 
	    {
	        courseService.deleteCourse(id);
	    }
}
