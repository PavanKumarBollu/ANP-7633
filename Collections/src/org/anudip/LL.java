package org.anudip;

import java.util.LinkedList;

public class LL {
	public static void main(String[] args) {
		
		
		LinkedList<String> students = new LinkedList<>();
		students.add("Rahul");
		students.add("Priya");
		students.add("Arjun");
		
//		System.out.println("Students :" + students);
//		
		students.addFirst("Sneha");
//		System.out.println("Students :" + students);
//		
		students.addLast("Kiran");
//		System.out.println("Students :" + students);
//		
//		System.out.println(students.getFirst());
//		System.out.println("Students :" + students);
//		System.out.println(students.getLast());
		System.out.println("Students :" + students);
		
//		students.removeFirst();
//		students.removeLast();
		
//		students.remove(1);
//		students.remove("Rahul");
		students.add(1, "Pavan");
		System.out.println("Students :" + students);
		students.set(1, "PavanKumar");
		System.out.println("Students :" + students);
	}

}
