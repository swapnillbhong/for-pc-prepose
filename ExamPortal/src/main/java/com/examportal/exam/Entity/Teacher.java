package com.examportal.exam.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
	@Column(length = 150)
	private String TeacherName;
	@Column(length = 100)
	private String TeacherCity;
	@Column(length = 150)
	private String TeacherGmail;
	@Column(length = 100)
	private int TeacherContact;
}
