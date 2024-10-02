package view;

import model.Student;
import java.util.List;
import java.util.Scanner;

public class StudentView {
    private final Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.print("Please choose: ");
        return scanner.nextInt();
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    public void showStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}