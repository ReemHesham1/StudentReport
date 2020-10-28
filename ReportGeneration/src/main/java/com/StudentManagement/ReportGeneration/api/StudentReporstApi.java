package com.StudentManagement.ReportGeneration.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.StudentManagement.ReportGeneration.Dto.StudentReportDTO;

@RequestMapping(value = "/api/report")
public interface StudentReporstApi {

	/**
	 * create new student report with student id
	 * 
	 * 
	 * @return StudentreportDto created
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	StudentReportDTO createNewReport(@RequestBody StudentReportDTO contactDto,
			@RequestParam(value = "id", defaultValue = "1", required = true) Long id);

	/**
	 * generete report for student
	 * 
	 * @param reportId
	 * @return StudentReportDto
	 */
	@GetMapping("/{id}")
	ResponseEntity<StudentReportDTO> findById(@PathVariable("id") Long id);

}
