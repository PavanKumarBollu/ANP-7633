package org.anudip.service;

import org.anudip.model.Student;

public class StudentService {

	private Student[] students;
	private int studentCount;

	public StudentService(int capacity) {
		students = new Student[capacity];
		studentCount = 0;
	}

//	Register a new Student
	public boolean registerStudent(Student student) {
		if (student == null) {
			System.out.println("Student Cannot be null");
			return false;
		}
		if (student.getUserId() <= 0) {
			System.out.println("Student Id Must be Postive");
			return false;
		}
		if (student.getName() == null || student.getName().trim().isEmpty()) {
			System.out.println("Student Name is Required");
		}
		if (student.getPhoneNumber() == null || student.getPhoneNumber().trim().isEmpty()
				|| student.getParentPhoneNumber() == null || student.getParentPhoneNumber().trim().isEmpty()
				|| student.getBatchName() == null || student.getBatchName().trim().isEmpty()) {
			System.out.println("Phone Numbers and batch name is required");
			return false;
		}
		if(studentCount >= students.length)
		{
			System.out.println("Student Storage is full");
			return false;
		}
		
		students[studentCount] = student;
		studentCount++;
		System.out.println("Student Registered Successfully");
		return true;
		
	}

	// returns the number of registered students
	public int getStudentCount() {
		return studentCount;
	}
	
	
	public Student getStudetnAt(int index)
	{
		if(index < 0 || index >= studentCount)
			return null;
		
		return students[index];
	}
	

}
