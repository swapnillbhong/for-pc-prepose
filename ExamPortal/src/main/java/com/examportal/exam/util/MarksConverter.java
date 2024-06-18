package com.examportal.exam.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.examportal.exam.Entity.Marks;
import com.examportal.exam.model.MarksDTO;

@Component
public class MarksConverter 
{
	public Marks ConvertToMarksEntity(MarksDTO marksDTO)
	{
		Marks marks = new Marks();
		if(marksDTO!=null)
		{
			BeanUtils.copyProperties(marksDTO, marks);
		}
		return marks;
	}
	public MarksDTO ConvertRoMarksDTO(Marks marks)
	{
		MarksDTO marksDTO = new MarksDTO();
		if(marks!=null)
		{
			BeanUtils.copyProperties(marks, marksDTO);
		}
		return marksDTO;
	}

}
