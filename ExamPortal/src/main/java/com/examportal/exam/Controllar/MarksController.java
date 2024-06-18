package com.examportal.exam.Controllar;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examportal.exam.Entity.Marks;
import com.examportal.exam.model.MarksDTO;
import com.examportal.exam.model.PaperDTO;
import com.examportal.exam.service.MarksService;
import com.examportal.exam.util.MarksConverter;

@RestController
@RequestMapping("/api")
public class MarksController 
{
	@Autowired
	private MarksService marksService;
	
	@Autowired
	private MarksConverter marksConverter;
	
	@PostMapping("/CreateMarks")
	ResponseEntity<MarksDTO> CreateMarks(MarksDTO marksDTO)
	{
		final Marks marks=marksConverter.ConvertToMarksEntity(marksDTO);
		return new ResponseEntity<MarksDTO>(marksService.CreateMarks(marks),HttpStatus.CREATED);
	}
	@GetMapping("/GetAllMarks")
	List<MarksDTO> GetAllMarks()
	{
		return marksService.GetAllMarks();
	}
	
	@GetMapping("/GetMarksById/{mid}")
	MarksDTO GetMakrsById(@PathVariable("mid") int id)
	{
		return marksService.GetMarksById(id);
	}
	
	@GetMapping("/UpdateMarksDetails/{mid}")
	MarksDTO UpdateMarksDetails(@PathVariable("mid") int id,@RequestBody MarksDTO marksDTO)
	{
		final Marks marks=marksConverter.ConvertToMarksEntity(marksDTO);
		return marksService.UpdateMarksDetails(id, marks);
	}
	@DeleteMapping("/DeleteMarksDetails/{mid}")
	String DeleteMarksDetails(@PathVariable("mid") int id)
	{
		return marksService.DeleteMarksDetails(id);
		
	}
		
}
