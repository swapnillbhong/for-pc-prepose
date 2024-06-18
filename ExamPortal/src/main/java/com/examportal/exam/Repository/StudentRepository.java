package com.examportal.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.exam.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>
{

}
