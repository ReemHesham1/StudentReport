package com.StudentManagement.ReportGeneration.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagement.ReportGeneration.Dto.StudentReportDTO;
import com.StudentManagement.ReportGeneration.Entity.StudentReportEntity;
import com.StudentManagement.ReportGeneration.api.StudentReporstApi;
import com.StudentManagement.ReportGeneration.service.StudentReportService;

@RestController
public class StudentReportRestController implements StudentReporstApi {

	@Autowired
	private StudentReportService reportService;

	@Autowired
	private ModelMapper reportMapper;

	public StudentReportRestController(StudentReportService reportService, ModelMapper reportMapper) {
		super();
		this.reportService = reportService;
		this.reportMapper = reportMapper;
	}

	@Override
	public StudentReportDTO createNewReport(StudentReportDTO reportDto, Long id) {
		StudentReportEntity data = reportMapper.map(reportDto, StudentReportEntity.class);
		StudentReportEntity newreport = reportService.save(data, id);
		StudentReportDTO createdReport = reportMapper.map(newreport, StudentReportDTO.class);
		return createdReport;
	}

	@Override
	public ResponseEntity<StudentReportDTO> findById(Long id) {
		Optional<StudentReportEntity> optionalReport = reportService.findById(id);

		if (optionalReport.isPresent()) {
			StudentReportEntity report = optionalReport.get();
			StudentReportDTO generetedReport = reportMapper.map(report, StudentReportDTO.class);
			return new ResponseEntity<>(generetedReport, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
