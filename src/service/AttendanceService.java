package service;

import dao.AttendanceDAO;
import model.Student;
import model.AttendanceRecord;
import exception.StudentNotFoundException;
import java.util.List;

public class AttendanceService {
    private AttendanceDAO dao;

    public AttendanceService() {
        this.dao = new AttendanceDAO();
    }

    public void addStudent(Student student) {
        dao.saveStudent(student);
        System.out.println("Student added successfully!");
    }

    public void markAttendance(String studentId, String date, String status) throws StudentNotFoundException {
        List<Student> students = dao.getAllStudents();
        boolean studentExists = false;
        
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                studentExists = true;
                break;
            }
        }

        if (!studentExists) {
            throw new StudentNotFoundException("Student with ID " + studentId + " not found.");
        }

        AttendanceRecord record = new AttendanceRecord(studentId, date, status);
        dao.saveAttendance(record);
        System.out.println("Attendance marked successfully!");
    }

    public void calculatePercentage(String studentId) throws StudentNotFoundException {
        List<Student> students = dao.getAllStudents();
        boolean studentExists = false;
        
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                studentExists = true;
                break;
            }
        }

        if (!studentExists) {
            throw new StudentNotFoundException("Student with ID " + studentId + " not found.");
        }

        List<AttendanceRecord> records = dao.getAllAttendance();
        int totalClasses = 0;
        int presentClasses = 0;
        
        for (AttendanceRecord record : records) {
            if (record.getStudentId().equals(studentId)) {
                totalClasses++;
                if (record.getStatus().equalsIgnoreCase("Present") || record.getStatus().equalsIgnoreCase("P")) {
                    presentClasses++;
                }
            }
        }
        
        if (totalClasses == 0) {
            System.out.println("No attendance records found for student ID " + studentId);
        } else {
            double percentage = ((double) presentClasses / totalClasses) * 100;
            System.out.printf("Attendance Percentage for Student ID %s: %.2f%%\n", studentId, percentage);
            if (percentage < 75.0) {
                System.out.println("[WARNING] Low attendance! Minimum required is 75%.");
            }
        }
    }

    public void searchStudent(String studentId) {
        List<Student> students = dao.getAllStudents();
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                System.out.println("Student Found: " + student);
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    public void showStudents() {
        List<Student> students = dao.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("List of Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
