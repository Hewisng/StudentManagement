package application;

import controller.StudentController;
import view.StudentView;

public class StudentManagementApp {
    public static void main(String[] args) {
        StudentView view = new StudentView();
        StudentController controller = new StudentController(view);

        while (true) {
            int choice = view.showMenu();

            switch (choice) {
                case 1:
                    controller.createStudent();
                    break;
                case 2:
                    controller.findAndSortStudent();
                    break;
                case 3:
                    controller.updateOrDeleteStudent();
            }
        }
    }
}