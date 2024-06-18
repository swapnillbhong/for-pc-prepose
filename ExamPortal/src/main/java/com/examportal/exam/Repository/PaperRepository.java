package com.examportal.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.exam.Entity.Paper;

public interface PaperRepository extends JpaRepository<Paper, Integer>
{

}
