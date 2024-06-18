package com.examportal.exam.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examportal.exam.Entity.Paper;
import com.examportal.exam.Repository.PaperRepository;
import com.examportal.exam.model.PaperDTO;
import com.examportal.exam.service.PaperService;
import com.examportal.exam.util.PaperConverter;

@Service
public class PaperServiceImpl implements PaperService
{
	@Autowired
	PaperRepository paperRepository;
	
	@Autowired
	private PaperConverter paperConverter;
	
	@Override
	public PaperDTO CreatePaper(Paper paper) 
	{
		Paper paper2=paperRepository.save(paper);
		return paperConverter.CovertToPaperDTO(paper2);
	}

	@Override
	public List<PaperDTO> GetAllPaper() 
	{
		List<Paper> papers= paperRepository.findAll();
		List<PaperDTO> dpos =new ArrayList();
		for(Paper p:papers)
		{
			dpos.add(paperConverter.CovertToPaperDTO(p));
		}
		return dpos;
	}

	@Override
	public PaperDTO GetPaperById(int id) 
	{
		Paper paper = paperRepository.findById(id).get();
		return paperConverter.CovertToPaperDTO(paper);
	}

	@Override
	public PaperDTO UpdatePaperDetails(int id, Paper paper) 
	{
		Paper paper2=paperRepository.findById(id).get();
		paper2.setPaperSubject(paper.getPaperSubject());
		paper2.setPaperType(paper.getPaperType());
		Paper paper3 = paperRepository.save(paper2);
		return paperConverter.CovertToPaperDTO(paper3);
	}

	@Override
	public String DeletePaperDetails(int id)
	{
		paperRepository.deleteById(id);
		return "Paper details Deleted Successfully";
	}

}
