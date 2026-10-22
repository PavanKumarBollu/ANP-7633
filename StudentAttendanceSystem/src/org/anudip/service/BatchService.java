package org.anudip.service;

import org.anudip.model.Batch;
import org.anudip.model.Student;
import org.anudip.model.Trainer;

public class BatchService {

	private Batch[] batches;

	private int batchCount;

	private StudentService studentService;

	private TrainerService trainerService;

	public BatchService(int capacity, StudentService studentService, TrainerService trainerService) {

		batches = new Batch[capacity];
		batchCount = 0;
		this.studentService = studentService;
		this.trainerService = trainerService;
	}

	public Batch searchBatchById(int batchId) {
		for (int i = 0; i < batchCount; i++) {
			if (batches[i].getBatchId() == batchId)
				;
			return batches[i];
		}
		return null;
	}

	public Batch searchBatchByName(String batchName) {
		for (int i = 0; i < batchCount; i++) {
			if (batches[i].getBatchName().equalsIgnoreCase(batchName))
				;
			return batches[i];

		}
		return null;
	}

	public boolean createBatch(int batchId, String batchName, int studentCapacity) {
		if (batchId < 0) {
			System.out.println("Batch Id Must be be Possitive");
			return false;
		}

		if (batchName == null || batchName.trim().isEmpty()) {
			System.out.println("Batch Name is Required");
			return false;

		}
		if (searchBatchById(batchId) != null) {
			System.out.println("Batch Already Exists");
			return false;
		}

		if (searchBatchByName(batchName.trim()) != null) {
			System.out.println("Batch Name Already Exists");
			return false;
		}
		if (batchCount >= batches.length) {
			System.out.println("Batch Storage is full");
			return false;
		}

		Batch batch = new Batch(batchId, batchName.trim(), studentCapacity);

		batches[batchCount] = batch;
		batchCount++;
		System.out.println("Batch Created Successfully");
		return true;

	}

	public boolean assignTrainerToBatch(int batchId, int trainerId) {
		Batch batch = searchBatchById(batchId);

		if (batch == null) {
			System.out.println("Batch not Found");
			return false;
		}

		Trainer trainer = trainerService.searchTrainerById(trainerId);

		if (trainer == null) {
			System.out.println("Trainer not found");
			return false;
		}

		batch.assignTrainer(trainer);

		System.out.println("Trainer Assigned To Batch Successfully");
		return true;
	}

	public boolean enrollStudent(int batchId, int studentId) {
		Batch batch = searchBatchById(batchId);
		if (batch == null) {
			System.out.println("Batch Not Found");
			return false;
		}

		Student student = studentService.searchStudentById(studentId);

		if (student == null) {
			System.out.println("Student not found");
			return false;
		}

		if (batch.hasStudent(studentId)) {
			System.out.println("Student Is Already in this batch");
			return false;
		}

		String currentBatch = student.getBatchName();

		if (currentBatch != null && !currentBatch.equalsIgnoreCase("Unassigned")
				&& !currentBatch.equalsIgnoreCase(batch.getBatchName())) {
			System.out.println("Student already belongs to Batch : " + currentBatch);
			return false;
		}
		
		if(!batch.addStudent(student))
		{
			System.out.println("Could not enroll student. batch may be full.");
			return false;
		}
		
		student.setBatchName(batch.getBatchName());
		
		System.out.println("Student Enrolled Successfully ");
		return true;
		
	}
	
	
	public void displayAllBatches()
	{
		if(batchCount == 0)
		{
			System.out.println("No Batches Created");
			return;
		}
		for(int i = 0; i < batchCount; i++)
		{
			batches[i].displayBatchDetails();
			System.out.println("-----------------------------------------------------");
			
			
		}
		System.out.println("Total batches : " + batchCount);
	}

	
	public void displayBatchById(int batchId)
	{
		Batch batch  = searchBatchById(batchId);
		if(batch == null)
		{
			System.out.println("Batch not Found");
			return;
		}
		batch.displayBatchDetails();
	}
	
}
