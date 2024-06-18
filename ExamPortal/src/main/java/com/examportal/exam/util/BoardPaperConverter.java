package com.examportal.exam.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.examportal.exam.Entity.BoardPaper;
import com.examportal.exam.model.BoardPaperDTO;

@Component

public class BoardPaperConverter 
{
	public BoardPaper ConvertBoardPaperEntity(BoardPaperDTO boardPaperDTO)
	{
		BoardPaper boardPaper = new BoardPaper();
		if(boardPaperDTO != null)
		{
			BeanUtils.copyProperties(boardPaperDTO, boardPaper);
		}
		return boardPaper ;
	}
	public BoardPaperDTO ConvertBoardPaperDTO(BoardPaper boardPaper)
	{
		BoardPaperDTO boardPaperDTO = new BoardPaperDTO();
		if(boardPaper != null)
		{
			BeanUtils.copyProperties(boardPaper, boardPaperDTO);
		}
		return boardPaperDTO ;
	}
}
