package com.examportal.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.exam.Entity.Marks;

public interface MarksRepository extends JpaRepository<Marks, Integer>
{

}
