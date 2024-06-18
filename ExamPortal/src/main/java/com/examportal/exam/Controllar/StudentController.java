package com.examportal.exam.Controllar;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examportal.exam.Entity.Student;
import com.examportal.exam.model.StudentDTO;
import com.examportal.exam.service.StudentService;
import com.examportal.exam.util.StudentConverter;

@RestController
@RequestMapping("/api")
public class StudentController 
{
	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentConverter studentConverter;
	
	@PostMapping("/CreateStudent")
	ResponseEntity<StudentDTO>CreateStudent( @RequestBody StudentDTO studentDTO)
	{	final Student student=studentConverter.ConvertToStudentEntity(studentDTO);
		return new ResponseEntity<StudentDTO>(studentService.CreateStudent(student),HttpStatus.CREATED) ;	
	}
	@GetMapping("/GetAllStudent")
	List<StudentDTO> GetAllStudent()
	{
		return studentService.GetAllStudent() ;	
	}
	
	@GetMapping("/GetStudentById/{sid}")
	StudentDTO GetStudentById(@PathVariable("sid") int id)
	{
		return studentService.GetStudentById(id);
	}
	@PutMapping("/UpdateStudentDetails/{sid}")
	StudentDTO UpdateStudentDetails(@PathVariable("sid") int id, @RequestBody StudentDTO studentDTO)
	{
		final Student student = studentConverter.ConvertToStudentEntity(studentDTO);
		return studentService.UpdateStudentDetails(id, student);
		
	}
	@DeleteMapping("/DeleteStudentDetails/{sid}")
	String DeleteStudentDetails(@PathVariable("sid") int id)
	{
		return studentService.DeleteStudentDetails(id);
	}
	
}

