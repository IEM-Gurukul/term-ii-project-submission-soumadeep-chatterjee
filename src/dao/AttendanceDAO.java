package dao;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {
    private static final String STUDENT_FILE = "students.txt";

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
}
