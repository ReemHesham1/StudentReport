package com.StudentManagement.ReportGeneration.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.StudentManagement.ReportGeneration.Entity.CourseEntity;
import com.StudentManagement.ReportGeneration.Entity.StudentEntity;
import com.StudentManagement.ReportGeneration.Entity.StudentReportEntity;
import com.StudentManagement.ReportGeneration.Utils.ErrorConstants;
import com.StudentManagement.ReportGeneration.Utils.GpaCalculator;
import com.StudentManagement.ReportGeneration.repository.StudentReportrepository;
import com.StudentManagement.ReportGeneration.repository.StudentRepository;
import com.StudentManagement.ReportGeneration.service.StudentReportService;

@Service
public class StudentReportServiceImpl implements StudentReportService {

	private StudentReportrepository reportRepo;

	private StudentRepository studentRepo;

	public StudentReportServiceImpl(StudentReportrepository reportRepo, StudentRepository studentRepo) {
		super();
		this.reportRepo = reportRepo;
		this.studentRepo = studentRepo;
	}

	@Override
	public StudentReportEntity save(StudentReportEntity report, Long id) {
		Assert.notNull(report, ErrorConstants.MSG_ERROR_NO_PARAM_KEY);
		Optional<StudentEntity> student = studentRepo.findById(id);
		if (!student.isPresent()) {
			throw new RuntimeException();
		}
		if (report.getSemesterNumber() == null) {
			throw new RuntimeException();
		}
		report.setStudents(student.get());
		List<CourseEntity> courses = student.get().getCourses();
		GpaCalculator gpas = GpaCalculator.calculateGPAs(courses, report.getSemesterNumber());
		report.setCumultativeGpa(gpas.getCumultativeGpa());
		report.setSemesterGpa(gpas.getSemesterGpa());

		return reportRepo.save(report);
	}

	@Override
	public Optional<StudentReportEntity> findById(Long id) {
		Assert.notNull(id, ErrorConstants.MSG_ERROR_OBJECT_NOT_FOUND_KEY);

		return reportRepo.findById(id);
	}

}
