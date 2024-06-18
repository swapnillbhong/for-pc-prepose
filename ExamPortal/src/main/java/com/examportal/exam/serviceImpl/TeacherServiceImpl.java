package com.examportal.exam.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.exam.Entity.Teacher;
import com.examportal.exam.Repository.TeacherRepository;
import com.examportal.exam.model.TeacherDTO;
import com.examportal.exam.service.TeacherService;
import com.examportal.exam.util.TeacherConverter;

@Service
public class TeacherServiceImpl implements TeacherService
{
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	private TeacherConverter teacherConverter;

	@Override
	public TeacherDTO CreateTeacher(Teacher teacher)
	{
		Teacher teacher2=teacherRepository.save(teacher);
		return teacherConverter.ConvertToTeacherDTO(teacher2);
	}

	@Override
	public List<TeacherDTO> GetAllTeacher()
	{
		List<Teacher> teachers= teacherRepository.findAll();
		List<TeacherDTO> dtos= new ArrayList();
		for(Teacher t:teachers)
		{
			dtos.add(teacherConverter.ConvertToTeacherDTO(t));
		}
		return dtos;
	}

	@Override
	public TeacherDTO GetTeacherById(int id) 
	{
		Teacher teacher=teacherRepository.findById(id).get();
		return teacherConverter.ConvertToTeacherDTO(teacher);
	}

	@Override
	public TeacherDTO UpdateTeacherDetails(int id, Teacher teacher)
	{
		Teacher teacher2=teacherRepository.findById(id).get();
		teacher2.setTeacherName(teacher.getTeacherName());
		teacher2.setTeacherCity(teacher.getTeacherCity());
		teacher2.setTeacherGmail(teacher.getTeacherGmail());
		teacher2.setTeacherContact(teacher.getTeacherContact());
		Teacher teacher3= teacherRepository.save(teacher2);
		return teacherConverter.ConvertToTeacherDTO(teacher3) ;
	}

	@Override
	public String DeleteTeacherDetails(int id) {
		teacherRepository.deleteById(id);
		return "Teacher Details Deleted Successfully";
	}

}
