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
}
