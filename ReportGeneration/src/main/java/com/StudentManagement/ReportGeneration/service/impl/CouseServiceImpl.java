package com.StudentManagement.ReportGeneration.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.StudentManagement.ReportGeneration.Entity.CourseEntity;
import com.StudentManagement.ReportGeneration.repository.CourseRepository;
import com.StudentManagement.ReportGeneration.service.CourseService;

@Service
public class CouseServiceImpl implements CourseService {

	private CourseRepository courseRepo;

	public CouseServiceImpl(CourseRepository courseRepo) {
		super();
		this.courseRepo = courseRepo;
	}

	@Override
	public List<CourseEntity> findAll() {

		return courseRepo.findAll();
	}

}
