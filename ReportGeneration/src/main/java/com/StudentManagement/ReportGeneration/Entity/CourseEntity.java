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

@Entity
@Table(name = "course")
public class CourseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	@NotNull
	private String name;

	@Column
	private String grade;

	@Column(name = "semester_season")
	private boolean semesterSeason;

	@Column(name = "semester_number")
	@NotNull
	private int semesterNumber;

	@ManyToOne
	@JoinColumn(name = "Student_id", nullable = false)
	private StudentEntity student;

	public CourseEntity(Long id, String name, String grade, boolean semesterSeason, int semesterNumber,
			StudentEntity student) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.semesterSeason = semesterSeason;
		this.semesterNumber = semesterNumber;
		this.student = student;
	}

	public CourseEntity() {
		super();
	}

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

	public boolean isSemesterSeason() {
		return semesterSeason;
	}

	public void setSemesterSeason(boolean semesterSeason) {
		this.semesterSeason = semesterSeason;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public int getSemesterNumber() {
		return semesterNumber;
	}

	public void setSemesterNumber(int semesterNumber) {
		this.semesterNumber = semesterNumber;
	}

}
