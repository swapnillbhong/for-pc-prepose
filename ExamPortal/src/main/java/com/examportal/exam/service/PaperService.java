package com.examportal.exam.service;

import java.util.List;

import com.examportal.exam.Entity.Paper;
import com.examportal.exam.model.PaperDTO;

public interface PaperService
{
	PaperDTO CreatePaper(Paper paper);
	List<PaperDTO> GetAllPaper();
	PaperDTO GetPaperById(int id);
	PaperDTO UpdatePaperDetails(int id,Paper paper);
	String DeletePaperDetails(int id);
}
