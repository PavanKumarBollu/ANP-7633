package org.anudip.base;

public class Main {

	public static void main(String[] args) {
		Employee e1 = new Employee(101, "Pavan", 10000, 30, 2, 5);
		Employee e2 = new Employee(102, "Rohit", 50000, 30, 3, 50);
		Employee e3 = new Employee(103, "Sharma", 60000, 30, 0, 0);
		Employee e4 = new Employee(104, "Kohlli", 1000000, 30, 10, 20);
		

		System.out.println("Employeee Details");
		System.out.println("==================");
		e1.displayEmployee();System.out.println();
		e2.displayEmployee();System.out.println();
		e3.displayEmployee();System.out.println();
		e4.displayEmployee();System.out.println();
		
		
		SalaryCalculator calSalary = new SalaryCalculator();
		calSalary.displaySalary(e1);
		calSalary.displaySalary(e2);
		calSalary.displaySalary(e3);
		calSalary.displaySalary(e4);
	}
}
