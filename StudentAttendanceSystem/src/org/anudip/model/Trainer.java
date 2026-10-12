package org.anudip.model;

public class Trainer extends User {
	
	private String assignedBatch;

	public Trainer(int userId, String name, String phoneNumber, String assignedBatch) {
		super(userId, name, phoneNumber);
		this.assignedBatch = assignedBatch;
	}

	public String getAssignedBatch() {
		return assignedBatch;
	}

	public void setAssignedBatch(String assignedBatch) {
		this.assignedBatch = assignedBatch;
	}

	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Assgined Batch : " + assignedBatch);
	}
	

}
