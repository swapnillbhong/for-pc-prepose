package com.examportal.exam.service;

import java.util.List;

import com.examportal.exam.Entity.BoardPaper;
import com.examportal.exam.model.BoardPaperDTO;

public interface BoardPaperService 
{
	BoardPaperDTO createBoardPaper(BoardPaper boardPaper);
	List<BoardPaperDTO> GetAllBoardPaper();
	BoardPaperDTO GetBoardPaperById(int id);
	BoardPaperDTO UpdateBoardPaperById(int id,BoardPaper boardPaper);
	String DeleteBoardPaper(int id);
}
