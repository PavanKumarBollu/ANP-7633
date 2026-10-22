package org.anudip.model;

import java.time.LocalDate;

public class AttendanceRecord {

	private int studentId;
	private int batchId;
	private LocalDate sessionDate;
	private AttendanceStatus status;
	
	

	public AttendanceRecord(int studentId, int batchId, LocalDate sessionDate, AttendanceStatus status) {
		this.studentId = studentId;
		this.batchId = batchId;
		this.sessionDate = sessionDate;
		this.status = status;
	}



	public void displayAttendance() {
		System.out.println("Student Id : " + studentId);
		System.out.println("Batch Id   : " + batchId);
		System.out.println("SessionDate: " + sessionDate);
		System.out.println("Status     : " + status);
	}



	public int getStudentId() {
		return studentId;
	}



	public int getBatchId() {
		return batchId;
	}



	public LocalDate getSessionDate() {
		return sessionDate;
	}



	public AttendanceStatus getStatus() {
		return status;
	}

}
