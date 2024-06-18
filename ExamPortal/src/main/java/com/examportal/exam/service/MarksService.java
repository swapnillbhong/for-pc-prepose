package com.examportal.exam.service;


import java.util.List;

import com.examportal.exam.Entity.Marks;
import com.examportal.exam.Entity.Student;
import com.examportal.exam.model.MarksDTO;

public interface MarksService 
{
	MarksDTO CreateMarks(Marks marks);
	List<MarksDTO> GetAllMarks();
	MarksDTO GetMarksById(int id);
	MarksDTO UpdateMarksDetails(int id,Marks marks);
	String DeleteMarksDetails(int id);

}
