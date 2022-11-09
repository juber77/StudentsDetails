package com.student.modal;

public class Student {
	
	private Long id;
	private String name;
	private String fatherName;
	private String email;
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
