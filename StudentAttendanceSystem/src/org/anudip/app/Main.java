package org.anudip.app;

import java.util.Scanner;

import org.anudip.controller.AttendanceController;
import org.anudip.controller.BatchController;
import org.anudip.controller.StudentController;
import org.anudip.controller.TrainerController;
import org.anudip.service.AttendanceService;
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

		AttendanceService attendanceService = new AttendanceService(500, batchService, trainerService);

		AttendanceController attendanceController = new AttendanceController(attendanceService, scanner);

		boolean running = true;

		while (running) {
			System.out.println("==================================================");
			System.out.println("STUDENT ATTENDANCE MENAGEMENT");
			System.out.println("==================================================");
			System.out.println("1. Register Student ");
			System.out.println("2. Search Student ");
			System.out.println("3. Display All the students ");
			System.out.println("4. Register Trainer ");
			System.out.println("5. Search Trainer ");
			System.out.println("6. Display All the Trainers ");
			System.out.println("7. Create Batch");
			System.out.println("8. Assign Trainer to Batch");
			System.out.println("9. Enroll Student in Batch");
			System.out.println("10. Display All Batches");
			System.out.println("11. Search Batch");
			System.out.println("12. Create Attendance Session");
			System.out.println("13. Mark Student Attendance");
			System.out.println("14. Finalize Attendance");
			System.out.println("15. View Daily Attendance");

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

			switch (choice) {
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
				trainerController.registerTrainer();
				;
				break;

			case 5:
				trainerController.searchTrainer();
				;
				break;

			case 6:
				trainerController.dispalyAllTrainers();
				break;

			case 7:
				batchController.createBatch();
				break;

			case 8:
				batchController.assignTrainer();
				break;

			case 9:
				batchController.enrolleStudent();
				break;

			case 10:
				batchController.dispalyAllBatches();
				break;

			case 11:
				batchController.searchBatch();
				break;

			case 12:
			    attendanceController.createSession();
			    break;

			case 13:
			    attendanceController.markAttendance();
			    break;

			case 14:
			    attendanceController.finalizeAttendance();
			    break;

			case 15:
			    attendanceController.viewAttendance();
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

	}

}
