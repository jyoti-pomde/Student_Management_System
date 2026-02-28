package Student_Management_System;
import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String name, int marks) {
        students.add(new Student(name, marks));
        System.out.println("✅ Student added successfully");
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        students.forEach(System.out::println);
    }

    public void searchStudent(String regNo) {
        for (Student s : students) {
            if (s.getRegisterNumber().equals(regNo)) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student not found");
    }

    public void deleteStudent(String regNo) {
        students.removeIf(s -> s.getRegisterNumber().equals(regNo));
        System.out.println("🗑 Student removed if existed");
    }
}