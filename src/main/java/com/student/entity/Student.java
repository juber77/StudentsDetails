package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private Long id;
	
	@Column(name = "student_name", nullable = false)
	private String name;
	
	@Column(name = "father_name", nullable = false)
	private String fatherName;
	
	@Column(name = "student_email", nullable = false)
	private String email;
	
	@Column(name = "phone_number", nullable = false)
	private long phoneNumber;

	public Student() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", fatherName=" + fatherName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
