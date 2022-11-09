package com.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<com.student.modal.Student> getStudents() {
		List<Student> entities = (List<Student>) studentRepository.findAll();
		List<com.student.modal.Student> students = new ArrayList<>();
		entities.forEach(entity -> {
			students.add(toData(entity));
		});
		return students;
	}

	@Override
	public com.student.modal.Student getStudent(long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			return toData(optionalStudent.get());
		}
		return null;
	}

	@Override
	public List<com.student.modal.Student> addStudent(com.student.modal.Student studentData) throws Exception {
		studentRepository.save(toEntity(studentData));
		return getStudents();
	}

	@Override
	public List<com.student.modal.Student> deleteStudent(long id) throws Exception {
		studentRepository.deleteById(id);
		return getStudents();
	}

	@Override
	public List<com.student.modal.Student> updateStudent(com.student.modal.Student studentData) throws Exception {
		Student student = toEntity(studentData);
		studentRepository.save(student);
		return getStudents();
	}

	private Student toEntity(com.student.modal.Student student) {
		Student entity = new Student();
		entity.setId(student.getId());
		entity.setName(student.getName());
		entity.setFatherName(student.getFatherName());
		entity.setEmail(student.getEmail());
		entity.setPhoneNumber(student.getPhoneNumber());
		return entity;
	}

	private com.student.modal.Student toData(Student student) {
		com.student.modal.Student studentData = new com.student.modal.Student();
		studentData.setId(student.getId());
		studentData.setName(student.getName());
		studentData.setEmail(student.getEmail());
		studentData.setFatherName(student.getFatherName());
		studentData.setPhoneNumber(student.getPhoneNumber());
		return studentData;
	}
}
