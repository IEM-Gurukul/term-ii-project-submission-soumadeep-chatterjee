import service.AttendanceService;
import model.Student;
import exception.StudentNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceService service = new AttendanceService();
        boolean running = true;

        System.out.println("--- Student Attendance Management System ---");

        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Show All Students");
            System.out.println("4. Search Student");
            System.out.println("5. Calculate Attendance Percentage");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            String input = scanner.nextLine();
            int choice = -1;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    service.addStudent(new Student(id, name));
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter Status (Present/Absent/Late): ");
                    String status = scanner.nextLine();
                    try {
                        service.markAttendance(studentId, date, status);
                    } catch (StudentNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    service.showStudents();
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    String searchId = scanner.nextLine();
                    service.searchStudent(searchId);
                    break;
                case 5:
                    System.out.print("Enter Student ID: ");
                    String calcId = scanner.nextLine();
                    try {
                        service.calculatePercentage(calcId);
                    } catch (StudentNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please select a number from 1 to 6.");
            }
        }
        scanner.close();
    }
}
