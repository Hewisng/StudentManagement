package controller;

import model.Student;
import view.StudentView;
import validation.Validation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentController {
    private final List<Student> studentList;
    private final StudentView view;

    public StudentController(StudentView view) {
        this.studentList = new ArrayList<>();
        this.view = view;
    }

    public void createStudent() {
        while (true) {
            if (studentList.size() >= 10) {
                boolean continueInput = Validation.validateYesNo("You have entered 10 students. Do you want to continue?");
                if (!continueInput) {
                    break;
                }
            }

            String id = Validation.validateID();
            String studentName = Validation.validateStudentName();
            String semester = Validation.validateSemester();
            String courseName = Validation.validateCourseName();

            studentList.add(new Student(id, studentName, semester, courseName));
            view.showMessage("Student added successfully!\n");
        }
    }

    public void findAndSortStudent() {
        String searchName = view.getInput("Enter Student Name (or part of it) to search: ");
        List<Student> foundStudents = new ArrayList<>();

        for (Student student : studentList) {
            if (student.getStudentName().toLowerCase().contains(searchName.toLowerCase())) {
                foundStudents.add(student);
            }
        }

        if (foundStudents.isEmpty()) {
            view.showMessage("No students found!");
        } else {
            foundStudents.sort(Comparator.comparing(Student::getStudentName));
            view.showStudents(foundStudents);
        }
    }

    public void updateOrDeleteStudent() {
        String id = view.getInput("Enter Student ID to find: ");

        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                String option = view.getInput("Do you want to update (U) or delete (D) this student? ");
                if (option.equalsIgnoreCase("U")) {
                    student.setStudentName(Validation.validateStudentName());
                    student.setSemester(Validation.validateSemester());
                    student.setCourseName(Validation.validateCourseName());
                    view.showMessage("Student updated successfully!");
                } else if (option.equalsIgnoreCase("D")) {
                    studentList.remove(student);
                    view.showMessage("Student deleted successfully!");
                }
                return;
            }
        }

        view.showMessage("Student with ID " + id + " not found.");
    }

    public void generateReport() {
        StringBuilder report = new StringBuilder("Student Report:\n");

        for (Student student : studentList) {
            report.append(student.getStudentName())
                  .append(" | ")
                  .append(student.getCourseName())
                  .append(" | Total Courses: 1\n");
        }

        view.showMessage(report.toString());
    }
}