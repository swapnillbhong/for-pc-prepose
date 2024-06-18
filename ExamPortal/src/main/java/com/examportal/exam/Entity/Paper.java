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
@Table(name = "Paper")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paper 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Paperid;
	@Column(length = 100)
	private String PaperSubject;
	@Column(length = 150)
	private String PaperType;
}
