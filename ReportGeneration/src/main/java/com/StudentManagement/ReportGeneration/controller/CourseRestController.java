package com.StudentManagement.ReportGeneration.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagement.ReportGeneration.Dto.CourseDTO;
import com.StudentManagement.ReportGeneration.Entity.CourseEntity;
import com.StudentManagement.ReportGeneration.api.CourseApi;
import com.StudentManagement.ReportGeneration.service.CourseService;

@RestController
public class CourseRestController implements CourseApi {

	@Autowired
	private ModelMapper CourseMapper;

	@Autowired
	private CourseService courseService;

	public CourseRestController(ModelMapper courseMapper, CourseService courseService) {
		super();
		CourseMapper = courseMapper;
		this.courseService = courseService;
	}

	@Override
	public List<CourseDTO> findByAll() {
		List<CourseEntity> courseList = courseService.findAll();
		List<CourseDTO> mapList = courseList.stream().map(course -> CourseMapper.map(course, CourseDTO.class))
				.collect(Collectors.toList());
		return mapList;
	}

}
