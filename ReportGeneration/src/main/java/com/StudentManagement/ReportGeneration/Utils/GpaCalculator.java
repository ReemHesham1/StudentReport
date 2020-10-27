package com.StudentManagement.ReportGeneration.Utils;

import java.util.List;

import com.StudentManagement.ReportGeneration.Entity.CourseEntity;

public class GpaCalculator {

	double semesterGpa;
	double cumultativeGpa;

	private GpaCalculator(double semesterGpa, double cumultativeGpa) {
		super();
		this.semesterGpa = semesterGpa;
		this.cumultativeGpa = cumultativeGpa;
	}

	public double getSemesterGpa() {
		return semesterGpa;
	}

	public double getCumultativeGpa() {
		return cumultativeGpa;
	}

	public static GpaCalculator calculateGPAs(List<CourseEntity> courses, int semesterNumber) {
		double semesterGpa = 0;
		double cumultativeGpa = 0;
		int numberOfCoursesInSemester = 0;
		for (CourseEntity course : courses) {
			if (course.getSemesterNumber() == semesterNumber) {
				numberOfCoursesInSemester++;
				semesterGpa += setGpaToNumber(course.getGrade());
			}
			cumultativeGpa += setGpaToNumber(course.getGrade());
		}
		semesterGpa = semesterGpa / numberOfCoursesInSemester;
		cumultativeGpa = cumultativeGpa / courses.size();
		return new GpaCalculator(semesterGpa, cumultativeGpa);

	}

	private static double setGpaToNumber(String symbole) {

		switch (symbole) {
		case "A":
			return 4.0;
		case "B":
			return 3.5;
		case "C":
			return 2.75;
		case "D":
			return 1.5;
		default:
			return 0.0;
		}

	}

}
