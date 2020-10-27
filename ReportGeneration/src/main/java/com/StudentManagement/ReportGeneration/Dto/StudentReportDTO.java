package com.StudentManagement.ReportGeneration.Dto;

import lombok.Data;

@Data
public class StudentReportDTO {

	private Long id;
	private Integer year;
	private double semesterGpa;
	private double cumultativeGpa;
	private Integer semesterNumber;
	private StudentDTO students;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public double getSemesterGpa() {
		return semesterGpa;
	}

	public void setSemesterGpa(double semesterGpa) {
		this.semesterGpa = semesterGpa;
	}

	public double getCumultativeGpa() {
		return cumultativeGpa;
	}

	public void setCumultativeGpa(double cumultativeGpa) {
		this.cumultativeGpa = cumultativeGpa;
	}

	public Integer getSemesterNumber() {
		return semesterNumber;
	}

	public void setSemesterNumber(Integer semesterNumber) {
		this.semesterNumber = semesterNumber;
	}

	public StudentDTO getStudents() {
		return students;
	}

	public void setStudents(StudentDTO students) {
		this.students = students;
	}

}
