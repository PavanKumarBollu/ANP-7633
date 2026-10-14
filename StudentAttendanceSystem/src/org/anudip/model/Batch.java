package org.anudip.model;

public class Batch {

	private int batchId;
	private String batchName;
	private Trainer trainer;
	private Student[] students;
	private int studentCount;

	public Batch(int batchId, String batchName, int studentCapacity) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.students = new Student[studentCapacity];
		this.studentCount = 0;
	}

	public int getBatchId() {
		return batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public int getStudentCount() {
		return studentCount;
	}

	public Student getStudetnAt(int index) {
		if (index < 0 || index >= studentCount)
			return null;

		return students[index];
	}

	public boolean assignTrainer(Trainer trainer) {
		if (trainer == null)
			return false;

		this.trainer = trainer;
		return true;

	}

	public boolean hasStudent(int studentId) {
		for (int i = 0; i < studentCount; i++) {
			if (students[i].getUserId() == studentId)
				return true;

		}
		return false;
	}

	public boolean addStudent(Student student) {
		if (student == null)
			return false;
		if (hasStudent(student.getUserId()))
			return false;
		if (studentCount >= students.length)
			return false;

		students[studentCount] = student;
		studentCount++;

		return true;
	}

	public void displayBatchDetails()
	{
		System.out.println("\nBatch Id : " + batchId);
		System.out.println("Batch Name : " + batchName);
		
		if(trainer == null)
			System.out.println("Trainer is not Assgined ");
		else
		{
			System.out.println("Trainer : " + trainer.getName() + "( ID : " + trainer.getUserId() + ")" );
		}
		System.out.println("Enroled Student : " + studentCount);
		if(studentCount == 0)
		{
			System.out.println("No Students Enrolled");
			
		}
		for(int i = 0; i < studentCount; i++)
		{
			Student student = students[i];
			
			System.out.println((i + 1 )+ ". " + student.getName() + " (ID : " + student.getUserId() + " )" );
		}
	}

}
