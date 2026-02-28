import java.util.ArrayList;
import java.util.Comparator;

class StudentService {
    ArrayList<Student> list = new ArrayList<>();

    void addStudent(Student s) {
        list.add(s);
        System.out.println("✅ Student added successfully. Your Register Number is: " + s.regNo);
    }

    void viewAll() {
        if (list.isEmpty()) {
            System.out.println("No students found");
            return;
        }

        // Sort by total marks descending (topper first)
        list.sort(Comparator.comparingInt(Student::total).reversed());

        double classTotal = 0;
        System.out.println("\nName | Register No | Total | Percentage | Grade/Result");
        for (Student s : list) {
            classTotal += s.total();
            String grade = s.isPass() ? s.grade() : "FAIL";
            System.out.println(s.name + " | " + s.regNo + " | " + s.total() + " | " + s.percentage() + " | " + grade);
        }

        // Show topper
        Student topper = list.get(0);
        System.out.println("\n🏆 Topper: " + topper.name + " (" + topper.total() + " marks)");
        System.out.println("📊 Class Average Marks: " + (classTotal / list.size()));
    }

    void checkResult(String regNo) {
        for (Student s : list) {
            if (s.regNo.equals(regNo)) {
                s.printMarkscard();
                return;
            }
        }
        System.out.println("Student not found");
    }

    void delete(String regNo) {
        boolean removed = list.removeIf(s -> s.regNo.equals(regNo));
        if (removed) System.out.println(" Student deleted successfully");
        else System.out.println("Student not found");
    }

    Student getStudentByReg(String regNo) {
        for (Student s : list) {
            if (s.regNo.equals(regNo)) return s;
        }
        return null;
    }
}