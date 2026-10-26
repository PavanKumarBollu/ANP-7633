
package org.anudip.service;

import java.time.LocalDate;

import org.anudip.model.AttendanceRecord;
import org.anudip.model.AttendanceSession;
import org.anudip.model.AttendanceStatus;
import org.anudip.model.Batch;



public class AttendanceService {

    private AttendanceSession[] sessions;
    private int sessionCount;

    private BatchService batchService;
    private TrainerService trainerService;

    public AttendanceService(int capacity,
                             BatchService batchService,
                             TrainerService trainerService) {

        sessions = new AttendanceSession[capacity];
        sessionCount = 0;

        this.batchService = batchService;
        this.trainerService = trainerService;
    }

    // Find a session by batch and date
    public AttendanceSession findSession(int batchId,
                                         LocalDate date) {

        for (int i = 0; i < sessionCount; i++) {

            AttendanceSession session = sessions[i];

            if (session.getBatchId() == batchId
                    && session.getSessionDate().equals(date)) {

                return session;
            }
        }

        return null;
    }

    // Create a session for the assigned trainer
    public boolean createSession(int trainerId,
                                 int batchId,
                                 LocalDate date) {

        if (date == null) {
            System.out.println("Session date is required.");
            return false;
        }

        if (date.isAfter(LocalDate.now())) {
            System.out.println(
                "Future attendance cannot be recorded."
            );
            return false;
        }

        if (trainerService.searchTrainerById(trainerId) == null) {
            System.out.println("Trainer not found.");
            return false;
        }

        Batch batch = batchService.searchBatchById(batchId);

        if (batch == null) {
            System.out.println("Batch not found.");
            return false;
        }

//        if (!batch.isTrainerAssigned(trainerId)) {
//            System.out.println(
//                "This trainer is not assigned to the batch."
//            );
//            return false;
//        }

        if (batch.getStudentCount() == 0) {
            System.out.println(
                "Cannot create attendance: batch has no students."
            );
            return false;
        }

        if (findSession(batchId, date) != null) {
            System.out.println(
                "An attendance session already exists for this batch and date."
            );
            return false;
        }

        if (sessionCount >= sessions.length) {
            System.out.println(
                "Session storage is full."
            );
            return false;
        }

        sessions[sessionCount] = new AttendanceSession(
            batchId,
            date,
            trainerId,
            batch.getStudentCount()
        );

        sessionCount++;

        System.out.println(
            "Attendance session created successfully."
        );

        return true;
    }

    // Mark a student's attendance
    public boolean markAttendance(int trainerId,
                                  int batchId,
                                  LocalDate date,
                                  int studentId,
                                  AttendanceStatus status) {

        AttendanceSession session = findSession(batchId, date);

        if (session == null) {
            System.out.println(
                "Create the attendance session first."
            );
            return false;
        }

        if (session.getTrainerId() != trainerId) {
            System.out.println(
                "Only the trainer who created this session can mark it."
            );
            return false;
        }

        if (session.isFinalized()) {
            System.out.println(
                "Attendance is already finalized."
            );
            return false;
        }

        Batch batch = batchService.searchBatchById(batchId);

//        if (batch == null || !batch.containsStudent(studentId)) {
//            System.out.println(
//                "Student does not belong to this batch."
//            );
//            return false;
//        }

        if (session.hasStudent(studentId)) {
            System.out.println(
                "Attendance already marked for this student."
            );
            return false;
        }

        if (status == null) {
            System.out.println("Attendance status is required.");
            return false;
        }

        AttendanceRecord record = new AttendanceRecord(
            studentId,
            batchId,
            date,
            status
        );

        if (!session.addRecord(record)) {
            System.out.println(
                "Unable to save attendance record."
            );
            return false;
        }

        System.out.println(
            "Attendance marked: Student "
            + studentId + " - " + status
        );

        return true;
    }

    // Finalize attendance only when all students are marked
    public boolean finalizeAttendance(int trainerId,
                                      int batchId,
                                      LocalDate date) {

        AttendanceSession session = findSession(batchId, date);

        if (session == null) {
            System.out.println("Attendance session not found.");
            return false;
        }

        if (session.getTrainerId() != trainerId) {
            System.out.println(
                "Only the trainer who created this session can finalize it."
            );
            return false;
        }

        if (session.isFinalized()) {
            System.out.println(
                "Attendance has already been finalized."
            );
            return false;
        }

        Batch batch = batchService.searchBatchById(batchId);

        if (batch == null) {
            System.out.println("Batch not found.");
            return false;
        }

        if (!session.finalizeSession(batch.getStudentCount())) {
            System.out.println(
                "Cannot finalize. Mark attendance for every student first."
            );
            System.out.println(
                "Marked: " + session.getRecordCount()
                + " / " + batch.getStudentCount()
            );
            return false;
        }

        System.out.println(
            "Attendance finalized successfully."
        );

        displayAttendance(batchId, date);

        return true;
    }

    // Display attendance for a batch and date
    public void displayAttendance(int batchId, LocalDate date) {

        AttendanceSession session = findSession(batchId, date);

        if (session == null) {
            System.out.println("Attendance session not found.");
            return;
        }

        Batch batch = batchService.searchBatchById(batchId);

        System.out.println("\n===== DAILY ATTENDANCE =====");
        System.out.println("Batch: " + batch.getBatchName());
        System.out.println("Date: " + date);
        System.out.println(
            "Status: "
            + (session.isFinalized() ? "FINALIZED" : "DRAFT")
        );

        int presentCount = 0;
        int absentCount = 0;

        for (int i = 0; i < session.getRecordCount(); i++) {

            AttendanceRecord record = session.getRecordAt(i);

            System.out.println(
                "Student ID: " + record.getStudentId()
                + " | " + record.getStatus()
            );

            if (record.getStatus() == AttendanceStatus.PRESENT) {
                presentCount++;
            } else {
                absentCount++;
            }
        }

        System.out.println("Present: " + presentCount);
        System.out.println("Absent: " + absentCount);
        System.out.println(
            "Unmarked: "
            + (batch.getStudentCount() - session.getRecordCount())
        );

        System.out.println("============================");
    }
}
