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
            System.out.println("\n======================================");
            System.out.println("             MAIN MENU                ");
            System.out.println("======================================");
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
                    System.out.println("\n--- Add Student ---");
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine().trim();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine().trim();
                    if (id.isEmpty() || name.isEmpty()) {
                        System.out.println("Error: Student ID and Name cannot be empty.");
                        break;
                    }
                    service.addStudent(new Student(id, name));
                    break;
                case 2:
                    System.out.println("\n--- Mark Attendance ---");
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine().trim();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine().trim();
                    System.out.print("Enter Status (P/A/L or Present/Absent/Late): ");
                    String status = scanner.nextLine().trim();
                    
                    if (studentId.isEmpty() || date.isEmpty() || status.isEmpty()) {
                        System.out.println("Error: All fields are required.");
                        break;
                    }
                    
                    if (!status.equalsIgnoreCase("P") && !status.equalsIgnoreCase("A") && !status.equalsIgnoreCase("L") && 
                        !status.equalsIgnoreCase("Present") && !status.equalsIgnoreCase("Absent") && !status.equalsIgnoreCase("Late")) {
                        System.out.println("Error: Invalid status. Please enter P/A/L or Present/Absent/Late.");
                        break;
                    }

                    try {
                        service.markAttendance(studentId, date, status);
                    } catch (StudentNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("\n--- All Students ---");
                    service.showStudents();
                    break;
                case 4:
                    System.out.println("\n--- Search Student ---");
                    System.out.print("Enter Student ID: ");
                    String searchId = scanner.nextLine().trim();
                    if (searchId.isEmpty()) {
                        System.out.println("Error: Student ID cannot be empty.");
                        break;
                    }
                    service.searchStudent(searchId);
                    break;
                case 5:
                    System.out.println("\n--- Calculate Percentage ---");
                    System.out.print("Enter Student ID: ");
                    String calcId = scanner.nextLine().trim();
                    if (calcId.isEmpty()) {
                        System.out.println("Error: Student ID cannot be empty.");
                        break;
                    }
                    try {
                        service.calculatePercentage(calcId);
                    } catch (StudentNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 6:
                    running = false;
                    System.out.println("\nExiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Error: Invalid option. Please select a number from 1 to 6.");
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
