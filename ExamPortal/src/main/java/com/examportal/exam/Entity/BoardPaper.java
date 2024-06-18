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
@Table(name = "BoardPaper")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BoardPaper 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 30)
	private int boardId;
	@Column(length = 50)
	private String boardSubject;
	@Column(length = 40)
	private int boardYear;
	
}
//
