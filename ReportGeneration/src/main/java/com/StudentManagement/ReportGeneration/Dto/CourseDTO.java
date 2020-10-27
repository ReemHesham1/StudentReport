package com.StudentManagement.ReportGeneration.Dto;

import com.StudentManagement.ReportGeneration.Utils.SemesterType;

import lombok.Data;

@Data
public class CourseDTO {

	private Long id;
	private String name;
	private String grade;
	private SemesterType semesterSeason;
	private int semesterNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getSemesterNumber() {
		return semesterNumber;
	}

	public void setSemesterNumber(int semesterNumber) {
		this.semesterNumber = semesterNumber;
	}

	public SemesterType getSemesterSeason() {
		return semesterSeason;
	}

	public void setSemesterSeason(SemesterType semesterSeason) {
		this.semesterSeason = semesterSeason;
	}

}
