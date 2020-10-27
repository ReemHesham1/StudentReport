package com.StudentManagement.ReportGeneration.service;

import java.util.List;

import com.StudentManagement.ReportGeneration.Entity.CourseEntity;

public interface CourseService {

	List<CourseEntity> findAll();
}
