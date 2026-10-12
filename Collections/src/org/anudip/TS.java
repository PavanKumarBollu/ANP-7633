package org.anudip;

import java.util.TreeSet;
//ctrl + shift + o for organizing the import statements
//Compartor and Comparable for custom sorting


public class TS {
	public static void main(String[] args) {
		TreeSet<String> students = new TreeSet<>();
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
