package com.examportal.exam.service;

import java.util.List;

import com.examportal.exam.Entity.Student;
import com.examportal.exam.model.StudentDTO;

public interface StudentService
{
	StudentDTO CreateStudent(Student student);
	List<StudentDTO> GetAllStudent();
	StudentDTO GetStudentById(int id);
	StudentDTO UpdateStudentDetails(int id,Student student);
	String DeleteStudentDetails(int id);
	
}
