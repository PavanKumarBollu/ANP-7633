package org.anudip.model;

public class User {
	
	// private fields 
	// constructor 
	// display method

	private int userId;
	private String name;
	private String phoneNumber;
	
	
	public User(int userId, String name, String phoneNumber) {
		super();
		this.userId = userId;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void displayDetails()
	{
		System.out.println("user Id :" + userId);
		System.out.println("name    :" + name);
		System.out.println("Phone   :" + phoneNumber);
	}

}
