package org.anudip.app;

import java.time.LocalDate;

import org.anudip.model.AttendanceRecord;
import org.anudip.model.Student;
import org.anudip.model.Trainer;

public class Main {

	public static void main(String[] args) {
		// this is the staring file of our application as of now
		// write the code to test the application 
		// code we have writtened so far
		
		Student student = new Student(
                101,
                "Rahul",
                "9876543210",
                "9876501234",
                "Java Batch A"
        );

        Trainer trainer = new Trainer(
                201,
                "Anjali",
                "9123456780",
                "Java Batch A"
        );

        AttendanceRecord record = new AttendanceRecord(
                101,
                LocalDate.now(),
                false
        );

        System.out.println("=== STUDENT DETAILS ===");
        student.displayDetails();

        System.out.println("\n=== TRAINER DETAILS ===");
        trainer.displayDetails();

        System.out.println("\n=== ATTENDANCE DETAILS ===");
        record.displayAttendance();

	}

}
