package org.anudip.controller;

import java.util.Scanner;

import org.anudip.service.BatchService;

public class BatchController {

	private BatchService batchService;
	private Scanner scanner;

	public BatchController(BatchService batchService, Scanner scanner) {
		this.batchService = batchService;
		this.scanner = scanner;
	}

	private int readInteger(String message) {
		while (true) {
			System.out.println(message);

			String input = scanner.nextLine().trim();

			try {
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Please Enter a valid number");
			}
		}
	}

	public void createBatch() {
		System.out.println("\n --- create Batch ---");

		int id = readInteger("Enter Batch Id: ");
		System.out.println("Enter Batch Name");
		String batchName = scanner.nextLine().trim();

		int capacity = readInteger("Enter Maximum Student Capacity");

		batchService.createBatch(id, batchName, capacity);

	}
	
	
	public void assignTrainer()
	{
		System.out.println("\n --- assign Trainer ---");
		
		int batchId = readInteger("Enter Batch ID :");
		int trainerId = readInteger("Enter Trainer ID:");
		
		batchService.assignTrainerToBatch(batchId, trainerId);
	}

	public void enrolleStudent() {
		System.out.println("\n --- Enroll Student ---");
		int batchId = readInteger("Enter Batch Id");
		int Id = readInteger("Enter Student Id");
		batchService.enrollStudent(batchId, Id);

	}

	public void dispalyAllBatches() {
		batchService.displayAllBatches();
	}

	public void searchBatch() {
		int batchId = readInteger("Enter Batch Id:");

		batchService.displayBatchById(batchId);
	}

}
