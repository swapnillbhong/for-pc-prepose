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

import com.examportal.exam.Entity.BoardPaper;
import com.examportal.exam.model.BoardPaperDTO;
import com.examportal.exam.service.BoardPaperService;
import com.examportal.exam.util.BoardPaperConverter;

@RestController
@RequestMapping("/api")
public class BoardPaperController 
{
	@Autowired
	private BoardPaperService boardPaperService;
	
	@Autowired
	private BoardPaperConverter boardPaperConverter;
	
	@PostMapping("/createBoardPaper")
	ResponseEntity<BoardPaperDTO>createBoardPaper(@RequestBody  BoardPaperDTO boardPaperDTO )
	{
		final BoardPaper boardPaper=boardPaperConverter.ConvertBoardPaperEntity(boardPaperDTO);
		return new ResponseEntity<BoardPaperDTO>(boardPaperService.createBoardPaper(boardPaper),HttpStatus.CREATED) ;
	}
	
	@GetMapping("/GetAllBoardPaper")
	List<BoardPaperDTO> GetAllBoardPaper()
	{
		return boardPaperService.GetAllBoardPaper();
	}
	
	@GetMapping("/GetBoardPaperById/{bid}")
	BoardPaperDTO GetBoardPaperById(@PathVariable("bid") int id)
	{
		return boardPaperService.GetBoardPaperById(id) ;
	}
	
	@GetMapping("/UpdateBoardPaperById/{bid}")
	BoardPaperDTO UpdateBoardPaperById(@PathVariable("bid") int id  ,@RequestBody BoardPaperDTO boardPaperDTO)
	{
		final BoardPaper boardPaper = boardPaperConverter.ConvertBoardPaperEntity(boardPaperDTO);
		return boardPaperService.UpdateBoardPaperById(id, boardPaper) ;
	}
	
	@DeleteMapping("/DeleteBoardPaper/{bid}")
	String DeleteBoardPaper(@PathVariable("bid") int id)
	{
		return boardPaperService.DeleteBoardPaper(id);
	}
}
