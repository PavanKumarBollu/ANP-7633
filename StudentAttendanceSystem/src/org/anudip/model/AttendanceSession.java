package org.anudip.model;

import java.time.LocalDate;

public class AttendanceSession {
	private int batchId;
	private LocalDate sessionDate;
	private int trainerId;
	
	
	private AttendanceRecord[] records;
	private int recordCount;
	private boolean finalized;
	
	public AttendanceSession(int batchId, LocalDate sessionDate,int trainerId, int capacity)
	{
		this.batchId = batchId;
		this.sessionDate =sessionDate;
		this.trainerId = trainerId;
		
		records = new AttendanceRecord[capacity];
		recordCount = 0;
		finalized =false;
		
	}

	public int getBatchId() {
		return batchId;
	}

	public LocalDate getSessionDate() {
		return sessionDate;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public AttendanceRecord[] getRecords() {
		return records;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public boolean isFinalized() {
		return finalized;
	}
	
	public AttendanceRecord getRecordAt(int index)
	{
		if(index < 0 || index >= recordCount)
		{
			return null;
		}
		return records[index];
	}
	
	public boolean hasStudent(int studentId)
	{
		for(int i = 0; i < recordCount; i++)
		{
			if(records[i].getStudentId() == studentId)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean addRecord(AttendanceRecord record)
	{
		if(finalized || record == null)
		{
			return false;
		}
		if(hasStudent(record.getStudentId()))
		{
			return false;
		}
		if(recordCount >= records.length)
		{
			return  false;
		}
		records[recordCount] = record;
		recordCount++;
		return true;
	}
	
	
	
	public boolean finalizeSession(int expectedStudents)
	{
		if(finalized)
		{
			return false;
		}
		if(recordCount != expectedStudents)
		{
			return false;
		}
		finalized = true;
		return true;
		
	}
	

}
