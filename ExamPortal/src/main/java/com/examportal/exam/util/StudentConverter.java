package com.examportal.exam.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.examportal.exam.Entity.Student;
import com.examportal.exam.model.StudentDTO;

@Component
public class StudentConverter 
{
	public Student ConvertToStudentEntity(StudentDTO studentDTO)
	{
		Student student = new Student();
		if(studentDTO!=null)
		{
			BeanUtils.copyProperties(studentDTO, student);
		}
		return student;
	}
	public StudentDTO CovertToStudentDTO(Student student)
	{
		StudentDTO studentDTO = new StudentDTO();
		if(student!=null)
		{
			BeanUtils.copyProperties(student, studentDTO);
		}
		return studentDTO;
	}
}
