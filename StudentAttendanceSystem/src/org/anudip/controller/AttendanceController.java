package org.anudip.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import org.anudip.model.AttendanceStatus;
import org.anudip.service.AttendanceService;



public class AttendanceController {

    private AttendanceService attendanceService;
    private Scanner scanner;

    public AttendanceController(
            AttendanceService attendanceService,
            Scanner scanner) {

        this.attendanceService = attendanceService;
        this.scanner = scanner;
    }

    private int readInteger(String message) {

        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(
                    "Please enter a valid number."
                );
            }
        }
    }

    private LocalDate readDate() {

        while (true) {
            System.out.print(
                "Enter session date (YYYY-MM-DD): "
            );

            String input = scanner.nextLine().trim();

            try {
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println(
                    "Invalid date. Example: 2026-10-22"
                );
            }
        }
    }

    public void createSession() {

        System.out.println("\n--- Create Attendance Session ---");

        int trainerId = readInteger("Enter Trainer ID: ");
        int batchId = readInteger("Enter Batch ID: ");
        LocalDate date = readDate();

        attendanceService.createSession(
            trainerId,
            batchId,
            date
        );
    }

    public void markAttendance() {

        System.out.println("\n--- Mark Attendance ---");

        int trainerId = readInteger("Enter Trainer ID: ");
        int batchId = readInteger("Enter Batch ID: ");
        LocalDate date = readDate();

        System.out.println("1. Present");
        System.out.println("2. Absent");

        int choice = readInteger("Select status: ");

        AttendanceStatus status;

        switch (choice) {

            case 1:
                status = AttendanceStatus.PRESENT;
                break;

            case 2:
                status = AttendanceStatus.ABSENT;
                break;

            default:
                System.out.println("Invalid attendance status.");
                return;
        }

        int studentId = readInteger("Enter Student ID: ");

        attendanceService.markAttendance(
            trainerId,
            batchId,
            date,
            studentId,
            status
        );
    }

    public void finalizeAttendance() {

        System.out.println("\n--- Finalize Attendance ---");

        int trainerId = readInteger("Enter Trainer ID: ");
        int batchId = readInteger("Enter Batch ID: ");
        LocalDate date = readDate();

        attendanceService.finalizeAttendance(
            trainerId,
            batchId,
            date
        );
    }

    public void viewAttendance() {

        System.out.println("\n--- View Daily Attendance ---");

        int batchId = readInteger("Enter Batch ID: ");
        LocalDate date = readDate();

        attendanceService.displayAttendance(
            batchId,
            date
        );
    }
}
