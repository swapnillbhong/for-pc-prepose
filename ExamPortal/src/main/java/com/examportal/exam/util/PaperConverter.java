package com.examportal.exam.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.examportal.exam.Entity.Paper;
import com.examportal.exam.model.PaperDTO;

@Component
public class PaperConverter
{
	public Paper ConvertPaperEntity(PaperDTO paperDTO)
	{
		Paper paper = new Paper();
		if(paperDTO!=null)
		{
			BeanUtils.copyProperties(paperDTO,  paper);
		}
		return paper;
	}
	public PaperDTO CovertToPaperDTO(Paper paper)
	{
		PaperDTO paperDTO = new PaperDTO();
		if(paper!=null)
		{
			BeanUtils.copyProperties(paper, paperDTO);
		}
		return paperDTO;
	}

}
