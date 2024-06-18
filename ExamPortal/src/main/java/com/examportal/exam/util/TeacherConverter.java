package com.examportal.exam.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.examportal.exam.Entity.Teacher;
import com.examportal.exam.model.TeacherDTO;

@Component
public class TeacherConverter
{
	public Teacher ConvertToTeacherEntity(TeacherDTO teacherDTO)
	{
		Teacher teacher = new Teacher();
		if(teacherDTO!=null)
		{
			BeanUtils.copyProperties(teacherDTO, teacher);
		}
		return teacher;
	}
	public TeacherDTO ConvertToTeacherDTO(Teacher teacher)
	{
		TeacherDTO teacherDTO = new TeacherDTO();
		if(teacherDTO!=null)
		{
			BeanUtils.copyProperties(teacher, teacherDTO);
		}
		return teacherDTO;
	}

}
