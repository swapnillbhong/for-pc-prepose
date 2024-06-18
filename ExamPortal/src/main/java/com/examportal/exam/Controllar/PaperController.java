package com.examportal.exam.Controllar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.exam.Entity.Paper;
import com.examportal.exam.model.PaperDTO;
import com.examportal.exam.model.TeacherDTO;
import com.examportal.exam.service.PaperService;
import com.examportal.exam.util.PaperConverter;

@RestController
@RequestMapping("/api")
public class PaperController
{
	@Autowired
	private PaperService paperService;
	
	@Autowired
	private PaperConverter paperConverter;
	
	@PostMapping("/CreatePaper")
	ResponseEntity<PaperDTO>CreatePaper(@Validated @RequestBody PaperDTO paperDTO)
	{
		final Paper paper=paperConverter.ConvertPaperEntity(paperDTO);
		return new ResponseEntity<PaperDTO>(paperService.CreatePaper(paper),HttpStatus.CREATED) ;
	}
	@GetMapping("/GetAllPaper")
	List<PaperDTO> GetAllPaper()
	{
		return paperService.GetAllPaper();
	}
	
	@GetMapping("/GetPaperById/{pid}")
	PaperDTO GetPaperById(@PathVariable("pid") int id)
	{
		return paperService.GetPaperById(id);
	}
	
	@GetMapping("/UpdatePaperDetails/{pid}")
	PaperDTO UpdatePaperDetails(@PathVariable("pid") int id,@RequestBody PaperDTO paperDTO)
	{
		final Paper paper=paperConverter.ConvertPaperEntity(paperDTO);
		return paperService.UpdatePaperDetails(id, paper);
	}
	@DeleteMapping("/DeletePaperDetails/{pid}")
	String DeletePaperDetails(@PathVariable("pid") int id)
	{
		return paperService.DeletePaperDetails(id);
	}
}
