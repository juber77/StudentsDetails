package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.modal.Student;
import com.student.service.IStudentService;

@RestController
@RequestMapping("/api/v1//student")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;

	/*
	 * return all students available in system
	 */
	@GetMapping()
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = studentService.getStudents();
		return new ResponseEntity<List<Student>>(students, null, HttpStatus.OK);
	}

	/*
	 * register student
	 */
	@PostMapping()
	public ResponseEntity<List<Student>> addStudent(@RequestBody Student studentDetail) {
		List<Student> students = new ArrayList<>();
		try {
			students = studentService.addStudent(studentDetail);
		} catch (Exception e) {
			return new ResponseEntity<List<Student>>(students, null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Student>>(students, null, HttpStatus.OK);
	}

	/*
	 * return student by it's id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable(value = "id") long studentId) {
		Student student = null;
		try {
			student = studentService.getStudent(studentId);
		} catch (Exception e) {
			return new ResponseEntity<Student>(student, null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Student>(student, null, HttpStatus.OK);
	}

	/*
	 * delete student by it's id
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<List<Student>> deleteStudent(@PathVariable(value = "id") long studentId) {
		List<Student> students = new ArrayList<>();
		try {
			students = studentService.deleteStudent(studentId);
		} catch (Exception e) {
			return new ResponseEntity<List<Student>>(students, null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Student>>(students, null, HttpStatus.OK);
	}

	/*
	 * update student details
	 */
	@PutMapping()
	public ResponseEntity<List<Student>> updateStudent(@RequestBody Student studentDetail) {
		List<Student> students = new ArrayList<>();
		try {
			students = studentService.updateStudent(studentDetail);
		} catch (Exception e) {
			return new ResponseEntity<List<Student>>(students, null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Student>>(students, null, HttpStatus.OK);
	}
}
