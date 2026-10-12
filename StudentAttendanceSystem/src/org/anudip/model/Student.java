package org.anudip.model;

public class Student extends User {

	private String parentPhoneNumber;
	private String batchName;
	
	public Student(int userId, String name, String phoneNumber, String parentPhoneNumber, String batchName) {
		super(userId, name, phoneNumber);
		this.parentPhoneNumber = parentPhoneNumber;
		this.batchName = batchName;
	}

	public String getParentPhoneNumber() {
		return parentPhoneNumber;
	}

	public void setParentPhoneNumber(String parentPhoneNumber) {
		this.parentPhoneNumber = parentPhoneNumber;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Parent Phone : " + parentPhoneNumber);
		System.out.println("Batch        : " + batchName);
		
	}
	
	
	

}
