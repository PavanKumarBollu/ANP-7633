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
	
	// Search Student
	
	public void searchStudent()
	{
		System.out.println("\n --- Search Student ---");
		int studentId = readInteger("Enter Student ID :");
		
		Student student = studentService.searchStudentById(studentId);
		
		if(student != null)
		{
			System.out.println("\n Student Found : ");
			student.displayDetails();
		}
		else
		{
			System.out.println("No Student Found with ID :" + studentId);
		}
	}
	
	
	// display all the students
	
	public void dispalyAllStudents()
	{
		System.out.println("\n --- All Students ---");
		int count = studentService.getStudentCount();
		
		if(count == 0)
		{
			System.out.println("No Students Registered Yet");
			return;
		}
		for(int i = 0; i < count; i++)
		{
			Student student = studentService.getStudetnAt(i);
			System.out.println("\nStudent : " + (i + 1));
			student.displayDetails();
			System.out.println("---------------------------------------------");
			
		}
		System.out.println("Total Students : " + count);
	}
	
	// Main menu
	public void start()
	{
		boolean running = true;
		
		while(running)
		{
			System.out.println("==================================================");
			System.out.println("STUDENT ATTENDANCE MENAGEMENT");
			System.out.println("==================================================");
			System.out.println("1. Register Student ");
			System.out.println("2. Search Student ");
			System.out.println("3. Display All the students ");
			System.out.println("4. Exit");
			
			int choice = readInteger("Enter Your Choice : ");
			switch(choice) {
			case 1:
				registerStudent();
				break;
			case 2:
				searchStudent();
				break;
			case 3:
				dispalyAllStudents();
				break;
			case 4:
				running = false;
				System.out.println("Application closed");
				break;
			default:
				System.out.println("Invalid Choice Try Again.... ");
				
			}
		}
	}

}
