package com.examportal.exam.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.exam.Entity.Marks;
import com.examportal.exam.Entity.Student;
import com.examportal.exam.Repository.MarksRepository;
import com.examportal.exam.model.MarksDTO;
import com.examportal.exam.service.MarksService;
import com.examportal.exam.util.MarksConverter;

@Service
public class MarksServiceImpl implements MarksService
{
	@Autowired
	MarksRepository marksRepository;
	
	@Autowired
	private MarksConverter marksConverter;
	
	@Override
	public MarksDTO CreateMarks(Marks marks) 
	{
		Marks marks2=marksRepository.save(marks);
		return marksConverter.ConvertRoMarksDTO(marks2) ;
	}

	@Override
	public List<MarksDTO> GetAllMarks()
	{
		List<Marks> marks=marksRepository.findAll();
		List<MarksDTO> dtos=new ArrayList();
		for(Marks m:marks)
		{
			dtos.add(marksConverter.ConvertRoMarksDTO(m));
		}
		return dtos;
	}

	@Override
	public MarksDTO GetMarksById(int id) 
	{
		Marks marks=marksRepository.findById(id).get();
		return marksConverter.ConvertRoMarksDTO(marks);
	}

	@Override
	public MarksDTO UpdateMarksDetails(int id, Marks marks) 
	{
		Marks marks2=marksRepository.findById(id).get();
		marks2.setMarksGrade(marks.getMarksGrade());
		marks2.setMarksScoore(marks.getMarksScoore());
		Marks marks3=marksRepository.save(marks2);
		return marksConverter.ConvertRoMarksDTO(marks3);
	}

	@Override
	public String DeleteMarksDetails(int id) 
	{
		marksRepository.deleteById(id);
		return "marks details deleted successfully";
	}

}
