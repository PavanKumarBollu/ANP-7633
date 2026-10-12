package org.anudip.model;

import java.time.LocalDate;

public class AttendanceRecord {

	private int studentId;
	private LocalDate sessionDate;
	private boolean present;// true means present false means absent

	public AttendanceRecord(int studentId, LocalDate sessionDate, boolean present) {
		super();
		this.studentId = studentId;
		this.sessionDate = sessionDate;
		this.present = present;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public LocalDate getSessionDate() {
		return sessionDate;
	}

	public void setSessionDate(LocalDate sessionDate) {
		this.sessionDate = sessionDate;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public void displayAttendance() {
		System.out.println("Student Id : " + studentId);
		System.out.println("Date       : " + sessionDate);

		if (present)
			System.out.println("Status : Present");
		else
			System.out.println("Status : Absent");
	}

}
