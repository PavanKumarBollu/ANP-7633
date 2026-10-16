package org.anudip.service;

import org.anudip.model.Trainer;

public class TrainerService {
	
	private Trainer[] trainers;
	private int trainerCount;
	
	public TrainerService(int capacity) {
		
		trainers = new Trainer[capacity];
		trainerCount = 0;
	}
	
	
	public Trainer[] getTrainers() {
		return trainers;
	}


	public int getTrainerCount() {
		return trainerCount;
	}


	public boolean registerTrainer(Trainer trainer) {
		if (trainer == null) {
			System.out.println("trainer Cannot be null");
			return false;
		}
		if (trainer.getUserId() <= 0) {
			System.out.println("trainer Id Must be Postive");
			return false;
		}
		if (trainer.getName() == null || trainer.getName().trim().isEmpty()) {
			System.out.println("trainer Name is Required");
		}
		
		if(trainerCount >= trainers.length)
		{
			System.out.println("trainer Storage is full");
			return false;
		}
		// check for duplicate trainer id
		if(searchTrainerById(trainer.getUserId()) != null)
		{
			System.out.println("A trainer With ID " + trainer.getUserId() + " already Exists");
			return false;
		}
		trainers[trainerCount] = trainer;
		trainerCount++;
		System.out.println("trainer Registered Successfully");
		return true;
		
	}
	
	public Trainer searchTrainerById(int trainerId)
	{
		for(int i = 0 ; i < trainerCount; i++)
		{
			if(trainers[i].getUserId() == trainerId)
			{
				return trainers[i];
			}
		}
		return null;
	}
	
	
	public void dispalyAllTrainers()
	{
		if(trainerCount == 0)
		{
			System.out.println("No Trainers Registered.");
			return ;
		}
		
		for (int i=0; i < trainerCount; i++)
		{
			System.out.println("\nTrainer " + (i=1));
			trainers[i].displayDetails();
			
		}
		
		System.out.println("Total trainers: "+ trainerCount);
	}

}
