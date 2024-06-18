package com.examportal.exam.service;

import java.util.List;

import com.examportal.exam.Entity.Teacher;
import com.examportal.exam.model.TeacherDTO;

public interface TeacherService 
{
	TeacherDTO CreateTeacher(Teacher teacher);
	List<TeacherDTO> GetAllTeacher();
	TeacherDTO GetTeacherById(int id);
	TeacherDTO UpdateTeacherDetails(int id,Teacher teacher);
	String DeleteTeacherDetails(int id);
}
