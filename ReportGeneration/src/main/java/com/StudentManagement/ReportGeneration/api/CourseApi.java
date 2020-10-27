package com.StudentManagement.ReportGeneration.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.StudentManagement.ReportGeneration.Dto.CourseDTO;

@RequestMapping(value = "/api/courses")
public interface CourseApi {

	/**
	 * get all courses
	 * 
	 * @return CourseDTO created
	 */

	@GetMapping
	List<CourseDTO> findByAll();
}
