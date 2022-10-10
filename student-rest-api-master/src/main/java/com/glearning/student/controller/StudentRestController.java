package com.glearning.student.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.student.model.Student;
import com.glearning.student.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

	private final StudentService studentService;

	public StudentRestController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public Set<Student> fetchAllStudents() {
		return this.studentService.fetchAllStudents();
	}

	@GetMapping("/{id}")
	public Student fetchStudentById(@PathVariable("id") long studentId) {
		return this.studentService.fetchStudentById(studentId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Student saveStudent(@RequestBody Student student) {
		return this.studentService.addStudent(student);
	}
	
	@PutMapping("/{id}" )
	public Student updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
		return this.studentService.updateStudent(id, student);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteStudentById(@PathVariable("id") long studentId) {
		this.studentService.deleteStudentById(studentId);
	}

}
