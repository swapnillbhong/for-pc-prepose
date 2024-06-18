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
@Table(name="Marks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marks 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MarksId;
	@Column(length = 100)
	private int MarksScoore;
	@Column(length = 90)
	private String MarksGrade;
}
