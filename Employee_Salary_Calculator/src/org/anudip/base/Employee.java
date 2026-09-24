package org.anudip.base;

public class Employee {
	int id;
	String name;
	double basicSalary;
	int workingDays;
	int absentDays;
	int overTimeHours;
	Employee(int id, String name, double basicSalary, int workingDays, int absentDays, int overTimeHours)
	{
		this.id = id;
		this.name = name;
		this.basicSalary = basicSalary;
		this.workingDays = workingDays;
		this.absentDays = absentDays;
		this.overTimeHours = overTimeHours;
	}
	void displayEmployee()
	{
		System.out.println("Employee Id :" + id);
		System.out.println("Employee name :" + name);
		System.out.println("Basic Salary :" + basicSalary);
		System.out.println("Working Days :" + workingDays);
		System.out.println("AbsentDays :" + absentDays);
		System.out.println("Overtime Hours :" + overTimeHours);
	}

}
