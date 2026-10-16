package org.anudip.app;

import java.util.Scanner;

import org.anudip.controller.BatchController;
import org.anudip.controller.StudentController;
import org.anudip.controller.TrainerController;
import org.anudip.service.BatchService;
import org.anudip.service.StudentService;
import org.anudip.service.TrainerService;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);

		
//		Services 
		StudentService studentService = new StudentService(100);
		TrainerService trainerService = new TrainerService(20);
		BatchService batchService = new BatchService(20, studentService, trainerService);
		
//		Controllers
		StudentController studentController = new StudentController(studentService, scanner);
		TrainerController trainerController = new TrainerController(trainerService, scanner);
		BatchController batchController = new BatchController(batchService, scanner);
		
		
		boolean running = true;
		
		while(running)
		{
			System.out.println("==================================================");
			System.out.println("STUDENT ATTENDANCE MENAGEMENT");
			System.out.println("==================================================");
			System.out.println("1. Register Student ");
			System.out.println("2. Search Student ");
			System.out.println("3. Display All the students ");
			System.out.println("4. Register Trainer ");
			System.out.println("5. Search Trainer ");
			System.out.println("6. Display All the Trainers ");
			
			
			
			System.out.println("0. Exit");
			
			System.out.println("Enter Your Choice : ");
			String input = scanner.nextLine().trim();
			int choice;
			try {
				choice = Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("Invalid Input Enter a Number");
				continue;
			}
			
			
			switch(choice) {
			case 1:
				studentController.registerStudent();
				break;
			case 2:
				studentController.searchStudent();
				break;
			case 3:
				studentController.dispalyAllStudents();
				break;
			case 4:
				trainerController.registerTrainer();;
				break;
			case 5:
				trainerController.searchTrainer();;
				break;
			case 6:
				trainerController.dispalyAllTrainers();
				break;
				
				
				
			case 0:
				running = false;
				System.out.println("Application closed");
				break;
			default:
				System.out.println("Invalid Choice Try Again.... ");
				
			}
		}
		
		
		scanner.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * // this is the staring file of our application as of now // write the code to
		 * test the application // code we have writtened so far
		 * 
		 * Student student = new Student( 101, "Rahul", "9876543210", "9876501234",
		 * "Java Batch A" );
		 * 
		 * Trainer trainer = new Trainer( 201, "Anjali", "9123456780", "Java Batch A" );
		 * 
		 * AttendanceRecord record = new AttendanceRecord( 101, LocalDate.now(), false
		 * );
		 * 
		 * System.out.println("=== STUDENT DETAILS ==="); student.displayDetails();
		 * 
		 * System.out.println("\n=== TRAINER DETAILS ==="); trainer.displayDetails();
		 * 
		 * System.out.println("\n=== ATTENDANCE DETAILS ===");
		 * record.displayAttendance();
		 */

	}

}
