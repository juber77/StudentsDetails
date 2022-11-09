package com.student.service;

import java.util.List;

import com.student.modal.Student;

public interface IStudentService {

	public List<Student> getStudents();

	public Student getStudent(long id);

	public List<Student> addStudent(Student student) throws Exception;

	public List<Student> deleteStudent(long id) throws Exception;

	public List<Student> updateStudent(Student student) throws Exception;

}
