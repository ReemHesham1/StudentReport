package com.StudentManagement.ReportGeneration.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.StudentManagement.ReportGeneration.Entity.CourseEntity;
import com.StudentManagement.ReportGeneration.Entity.StudentEntity;
import com.StudentManagement.ReportGeneration.Entity.StudentReportEntity;
import com.StudentManagement.ReportGeneration.repository.StudentReportrepository;
import com.StudentManagement.ReportGeneration.repository.StudentRepository;
import com.StudentManagement.ReportGeneration.service.impl.StudentReportServiceImpl;

@RunWith(SpringRunner.class)
public class StudentReportServiceTest {
	public final static String STUDENT_NAME = "reem";

	@InjectMocks
	private StudentReportServiceImpl service;

	@Mock
	private StudentReportrepository reportRepo;

	@Mock
	private StudentRepository studentRepo;

	public StudentEntity PrepareStudentEntity() {
		StudentEntity student = new StudentEntity();
		student.setId(1L);
		student.setCourses(prepareCourses(student));
		student.setStudentName(STUDENT_NAME);
		return student;

	}

	public List<CourseEntity> prepareCourses(StudentEntity student) {
		List<CourseEntity> courses = new ArrayList<CourseEntity>();
		courses.add(new CourseEntity(1L, "algo", "A", false, 1, student));
		courses.add(new CourseEntity(2L, "algo", "B", false, 1, student));
		courses.add(new CourseEntity(3L, "algo", "C", false, 1, student));
		courses.add(new CourseEntity(4L, "algo", "A", false, 3, student));
		courses.add(new CourseEntity(5L, "algo", "B", false, 3, student));
		courses.add(new CourseEntity(6L, "algo", "D", false, 1, student));
		return courses;
	}

	public StudentReportEntity prepareReport() {
		StudentReportEntity report = new StudentReportEntity();
		report.setSemesterNumber(1);
		report.setYear(2020);
		return report;

	}

	@Test
	public void gernerateRepot_happySenario_test() {
		StudentEntity student = PrepareStudentEntity();
		StudentReportEntity report = prepareReport();
		Mockito.when(studentRepo.findById(Mockito.any())).thenReturn(Optional.of(student));
		Mockito.when(reportRepo.save(Mockito.any())).thenReturn(report);
		StudentReportEntity studentReport = service.save(report, 1L);
		assertEquals(studentReport.getYear(), 2020);
		assertEquals(studentReport.getCumultativeGpa(), 3.2083, 0.0001);
		assertEquals(studentReport.getSemesterGpa(), 2.9375);

	}
}
