package org.anudip.model;

public class Trainer extends User {

	public Trainer(int userId, String name, String phoneNumber) {
		super(userId, name, phoneNumber);

	}

	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Role : Trainer");
	}

}
