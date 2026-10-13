package org.anudip.controller;

import java.util.Scanner;

import org.anudip.model.Student;
import org.anudip.service.StudentService;

public class StudentController {
	
	private StudentService studentService;
	private Scanner scanner;
	
	public StudentController(StudentService studentService, Scanner scanner) {
		super();
		this.studentService = studentService;
		this.scanner = scanner;
	}
	
	
	private int readInteger(String message)
	{
		while(true)
		{
			System.out.println(message);
			
			String input = scanner.nextLine().trim();
			
			try
			{
				return Integer.parseInt(input);
			}catch(NumberFormatException e)
			{
				System.out.println("Invalid input, Please Try Again");
			}
		}
	}
	
	
	
	public void registerStudent()
	{
		System.out.println("\n --- Register Student ---");
		int studentId = readInteger("Enter Studetn Id: ");
		System.out.println("Enter Studetn Name: ");
		String name = scanner.nextLine().trim();
		System.out.println("Enter Phone Number : ");
		String phone = scanner.nextLine().trim();
		System.out.println("Enter Parent PHone Nunber : ");
		String parentPhone = scanner.nextLine().trim();
		
		System.out.println("Enter Batch Code : ");
		String batch = scanner.nextLine().trim();
		
		
		Student student = new Student(studentId, name, phone, parentPhone, batch);
		
		studentService.registerStudent(student);
		
	}

}
