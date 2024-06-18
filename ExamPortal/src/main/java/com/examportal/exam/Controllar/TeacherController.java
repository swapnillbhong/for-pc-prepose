package com.examportal.exam.Controllar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examportal.exam.Entity.Teacher;
import com.examportal.exam.model.StudentDTO;
import com.examportal.exam.model.TeacherDTO;
import com.examportal.exam.service.TeacherService;
import com.examportal.exam.util.TeacherConverter;

@RestController
@RequestMapping("/api")
public class TeacherController 
{
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private TeacherConverter teacherConverter;
	
	@PostMapping("/CreateTeacher")
	ResponseEntity<TeacherDTO>CreateTeacher(@Validated @RequestBody TeacherDTO teacherDTO)
	{
		final Teacher teacher=teacherConverter.ConvertToTeacherEntity(teacherDTO);
		return new ResponseEntity<TeacherDTO>(teacherService.CreateTeacher(teacher),HttpStatus.CREATED);
	}
	@GetMapping("/GetAllTeacher")
	List<TeacherDTO> GetAllTeacher()
	{
		return teacherService.GetAllTeacher();
	}
	
	@GetMapping("/GetTeacherById/{sid}")
	TeacherDTO GetTeacherById(@PathVariable("tid") int id)
	{
		return teacherService.GetTeacherById(id);
	}
	
	@GetMapping("/UpdateTeacherDetails/{tid}")
	TeacherDTO UpdateTeacherDetails(@PathVariable("tid") int id,@RequestBody TeacherDTO teacherDTO)
	{
		final Teacher teacher= teacherConverter.ConvertToTeacherEntity(teacherDTO);
		return teacherService.UpdateTeacherDetails( id , teacher);
		
	}
	@DeleteMapping("/DeleteTeacherDetails/{tid}")
	String DeleteTeacherDetails(@PathVariable("tid") int id)
	{
		return teacherService.DeleteTeacherDetails(id);
	}
}
