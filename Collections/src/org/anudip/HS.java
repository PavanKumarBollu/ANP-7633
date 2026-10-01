package org.anudip;

import java.util.HashSet;

public class HS {

	public static void main(String[] args) {
		
		HashSet<String> students = new HashSet<>();
		
		students.add("Pavan");
		students.add("Rahul");
		students.add("Sneha");
		students.add("Pavan"); // Duplicate Value
		students.add(null);
		System.out.println(students);
		

	}

}
