package com.StudentManagement.ReportGeneration.service;

import java.util.Optional;

import com.StudentManagement.ReportGeneration.Entity.StudentReportEntity;

public interface StudentReportService {

	StudentReportEntity save(StudentReportEntity report, Long id);

	public Optional<StudentReportEntity> findById(Long id);
}
