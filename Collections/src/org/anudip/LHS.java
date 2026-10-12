package org.anudip;

import java.util.LinkedHashSet;

public class LHS {

	public static void main(String[] args) {
	
		
		LinkedHashSet<String> students = new LinkedHashSet<>();
		students.add("Pavan");
		students.add("Rahul");
		students.add("Sneha");
		students.add("Arjun");
		System.out.println(students);
		// what happens with duplicates in the LHS
		
		students.add("Pavan");
		students.add("Rahul");
		students.add("Pavan");
		System.out.println(students);
		

	}

}
