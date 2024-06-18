package com.examportal.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.exam.Entity.BoardPaper;

public interface BoardPaperRepository extends JpaRepository<BoardPaper, Integer>
{
	

}
