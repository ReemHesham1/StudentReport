package com.StudentManagement.ReportGeneration.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "student_report")
public class StudentReportEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	private Integer year;

	@Column(name = "semester_number")
	@NotNull
	private Integer semesterNumber;

	@Column(name = "semester_gpa")
	private double semesterGpa;

	@Column(name = "cumultative_gpa")
	private double cumultativeGpa;

	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private StudentEntity students;

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

	public Integer getSemesterNumber() {
		return semesterNumber;
	}

	public void setSemesterNumber(Integer semesterNumber) {
		this.semesterNumber = semesterNumber;
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

	public StudentEntity getStudents() {
		return students;
	}

	public void setStudents(StudentEntity students) {
		this.students = students;
	}

}
