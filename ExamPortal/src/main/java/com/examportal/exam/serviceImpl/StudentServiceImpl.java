package com.examportal.exam.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.exam.Entity.Student;
import com.examportal.exam.Repository.StudentRepository;
import com.examportal.exam.model.StudentDTO;
import com.examportal.exam.service.StudentService;
import com.examportal.exam.util.StudentConverter;

import ch.qos.logback.core.pattern.Converter;
import jakarta.persistence.Convert;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	StudentRepository repository;

	@Autowired
	private StudentConverter studentConverter;
	
	@Override
	public StudentDTO CreateStudent(Student student)
	{
		Student student2=repository.save(student);
		return studentConverter.CovertToStudentDTO(student2); 
	}

	@Override
	public List<StudentDTO> GetAllStudent() 
	{
		List<Student> students=repository.findAll();
		List<StudentDTO> dtoList=new ArrayList();
		for(Student s:students)
		{
			dtoList.add(studentConverter.CovertToStudentDTO(s));
		}
		return dtoList;
	}

	@Override
	public StudentDTO GetStudentById(int id) 
	{
		Student student=repository.findById(id).get();
		return studentConverter.CovertToStudentDTO(student);
	}

	@Override
	public StudentDTO UpdateStudentDetails(int id, Student student) 
	{
		Student student2=repository.findById(id).get();
		student2.setStudentName(student.getStudentName());
		student2.setStudentAge(student.getStudentAge());
		student2.setStudentCity(student.getStudentCity());
		student2.setStudentClass(student.getStudentClass());
		student2.setStudentGmail(student.getStudentGmail());
		student2.setStudentContact(student.getStudentContact());
		Student student3=repository.save(student2);
		return studentConverter.CovertToStudentDTO(student3);
	}

	@Override
	public String DeleteStudentDetails(int id)
	{
		repository.deleteById(id);
		return "Student details deleted";
	}

}
