package org.anudip.controller;

import java.util.Scanner;

import org.anudip.model.Student;
import org.anudip.model.Trainer;
import org.anudip.service.TrainerService;

public class TrainerController {
	
	private TrainerService trainerService;
	private Scanner scanner;
	
	
	public TrainerController(TrainerService trainerService, Scanner scanner)
	{
		this.trainerService = trainerService;
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
				System.out.println("Please Enter a valid number");
			}
		}
	}
	
	
	public void registerTrainer()
	{
		System.out.println("\n --- Register Trainer --- ");
		int id = readInteger("Enter Trainer Id ");
		
		System.out.println("Enter Trainer Name :");
		String name = scanner.nextLine().trim();
	
		System.out.println("Enter Phone Number");
		String phone = scanner.nextLine().trim();
				
		Trainer trainer = new Trainer(id, name, phone);
		trainerService.registerTrainer(trainer);
	}
	
	public void searchTrainer()
	{
		int id = readInteger("Enter Trainer Id");
		
		Trainer trainer = trainerService.searchTrainerById(id);
		if(trainer == null)
			System.out.println("Trainer Not Found.");
		else
			trainer.displayDetails();
	}
	
	
	// display all the Trainers
	
		public void dispalyAllTrainers()
		{
			System.out.println("\n --- All Trainers  ---");
			int count = trainerService.getTrainerCount();
			
			if(count == 0)
			{
				System.out.println("No trainers Registered Yet");
				return;
			}
			for(int i = 0; i < count; i++)
			{
//				Student student = trainerService.get;
//				System.out.println("\nStudent : " + (i + 1));
//				student.displayDetails();
//				System.out.println("---------------------------------------------");
				
			}
			System.out.println("Total trainers : " + count);
		}

}
