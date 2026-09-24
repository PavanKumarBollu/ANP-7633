package org.anudip.base;

public class SalaryCalculator {
	
	
	double calculateLOP(Employee emp)
	{
		double dailySalary = emp.basicSalary / emp.workingDays;
		double lop = dailySalary * emp.absentDays;
		return lop;
	}
	
	double calculateOvertime(Employee emp)
	{
		double overTimeRate = 100;
		double overTimePay = emp.overTimeHours * overTimeRate;
		return overTimePay;
	}
	
	double calculateFinalSalary(Employee emp)
	{
		double lop = calculateLOP(emp);
		double overTime = calculateOvertime(emp);
		double finalSalary = emp.basicSalary - lop + overTime;
		return finalSalary;
		
	}
	
	void displaySalary(Employee emp)
	{
		double lop = calculateLOP(emp);
		double overTime = calculateOvertime(emp);
		double finalSalary = emp.basicSalary - lop + overTime;
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("Salary Details :-");
		System.out.println("--------------------------------");
		System.out.println("Employe : " + emp.name);
		System.out.println("Basic Salary : " + emp.basicSalary);
		System.out.println("LOP :" + lop);
		System.out.println("Overtime Pay : " + overTime);
		System.out.println("FInal Salary : " + finalSalary);
		
	}

}
