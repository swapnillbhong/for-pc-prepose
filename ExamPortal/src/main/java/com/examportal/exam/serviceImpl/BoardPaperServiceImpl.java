package com.examportal.exam.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.exam.Entity.BoardPaper;
import com.examportal.exam.Repository.BoardPaperRepository;
import com.examportal.exam.model.BoardPaperDTO;
import com.examportal.exam.service.BoardPaperService;
import com.examportal.exam.util.BoardPaperConverter;

@Service
public class BoardPaperServiceImpl implements BoardPaperService 
{
	@Autowired
	BoardPaperRepository boardPaperRepository;
	
	@Autowired
	BoardPaperConverter boardPaperConverter;
	
	@Override
	public BoardPaperDTO createBoardPaper(BoardPaper boardPaper) 
	{
		BoardPaper boardPaper2=boardPaperRepository.save(boardPaper);
		return boardPaperConverter.ConvertBoardPaperDTO(boardPaper2);
	}

	@Override
	public List<BoardPaperDTO> GetAllBoardPaper()
	{
		List<BoardPaper> boardPapers=boardPaperRepository.findAll();
		List<BoardPaperDTO> bpos=new ArrayList();
		for(BoardPaper b:boardPapers)
		{
			bpos.add(boardPaperConverter.ConvertBoardPaperDTO(b));
		}
		return bpos;
	}

	@Override
	public BoardPaperDTO GetBoardPaperById(int id)
	{
		BoardPaper boardPaper=boardPaperRepository.findById(id).get();
		return boardPaperConverter.ConvertBoardPaperDTO(boardPaper);
	}

	@Override
	public BoardPaperDTO UpdateBoardPaperById(int id, BoardPaper boardPaper)
	{
		BoardPaper boardPaper2 = boardPaperRepository.findById(id).get();
		boardPaper2.setBoardSubject(boardPaper.getBoardSubject());
		boardPaper2.setBoardYear(boardPaper.getBoardYear());
		BoardPaper boardPaper3=boardPaperRepository.save(boardPaper2);
		return boardPaperConverter.ConvertBoardPaperDTO(boardPaper3);
	}

	@Override
	public String DeleteBoardPaper(int id) 
	{
		boardPaperRepository.deleteById(id);
		return "Deleted board paper Successfully";
	}

}
