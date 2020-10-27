package com.StudentManagement.ReportGeneration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentManagement.ReportGeneration.Entity.StudentReportEntity;

@Repository
public interface StudentReportrepository extends JpaRepository<StudentReportEntity, Long> {

}
