package validation;

import java.util.Scanner;

public class Validation {

    private static final Scanner scanner = new Scanner(System.in);

    // Validate ID (non-empty)
    public static String validateID() {
        while (true) {
            System.out.print("Enter Student ID: ");
            String id = scanner.nextLine();
            if (id.isEmpty()) {
                System.out.println("Error: ID cannot be empty. Please try again.");
            } else {
                return id;
            }
        }
    }

    // Validate Student Name (non-empty)
    public static String validateStudentName() {
        while (true) {
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Error: Name cannot be empty. Please try again.");
            } else {
                return name;
            }
        }
    }

    // Validate Semester (non-empty)
    public static String validateSemester() {
        while (true) {
            System.out.print("Enter Semester: ");
            String semester = scanner.nextLine();
            if (semester.isEmpty()) {
                System.out.println("Error: Semester cannot be empty. Please try again.");
            } else {
                return semester;
            }
        }
    }

    // Validate Course Name (Only allow Java, .Net, C/C++)
    public static String validateCourseName() {
        while (true) {
            System.out.print("Enter Course Name (Java, .Net, C/C++): ");
            String course = scanner.nextLine();
            if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase(".Net") || course.equalsIgnoreCase("C/C++")) {
                return course;
            } else {
                System.out.println("Error: Invalid course name. Please choose Java, .Net, or C/C++.");
            }
        }
    }

    // Validate yes/no answers (Y/N)
    public static boolean validateYesNo(String message) {
        while (true) {
            System.out.print(message + " (Y/N): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                return true;
            } else if (answer.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Error: Please enter Y or N.");
            }
        }
    }
}