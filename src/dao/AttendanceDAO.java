package dao;

import model.Student;
import model.AttendanceRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {
    private static final String STUDENT_FILE = "students.txt";
    private static final String ATTENDANCE_FILE = "attendance.txt";

    public void saveStudent(Student student) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENT_FILE, true))) {
            writer.write(student.getId() + "," + student.getName());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving student to file: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        File file = new File(STUDENT_FILE);
        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    students.add(new Student(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading students from file: " + e.getMessage());
        }
        return students;
    }

    public void saveAttendance(AttendanceRecord record) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ATTENDANCE_FILE, true))) {
            writer.write(record.getStudentId() + "," + record.getDate() + "," + record.getStatus());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving attendance to file: " + e.getMessage());
        }
    }

    public List<AttendanceRecord> getAllAttendance() {
        List<AttendanceRecord> records = new ArrayList<>();
        File file = new File(ATTENDANCE_FILE);
        if (!file.exists()) {
            return records;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 3);
                if (parts.length == 3) {
                    records.add(new AttendanceRecord(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading attendance from file: " + e.getMessage());
        }
        return records;
    }
}
