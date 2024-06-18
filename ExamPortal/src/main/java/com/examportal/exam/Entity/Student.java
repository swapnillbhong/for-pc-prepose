package com.examportal.exam.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Student")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	@Column(length = 30)
	private String studentName;
	@Column(length = 30)
	private int studentClass;
	@Column(length = 30)
	private int studentAge;
	@Column(length = 30)
	private String studentCity;
	@Column(length = 30)
	private String studentGmail;
	@Column(length = 30)
	private int studentContact;
	
	//one student can give many paper
	
	
	
}
