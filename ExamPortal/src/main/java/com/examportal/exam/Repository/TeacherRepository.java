package com.examportal.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.exam.Entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>
{

}
