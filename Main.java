import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Check Result");
            System.out.println("3. View All Students");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Invalid input. Please enter a number 1-5.");
                sc.nextLine(); // consume invalid input
                continue;
            }
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("\nEnter Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter your marks:");

                    int p = getValidMarks(sc, "Physics");
                    int c = getValidMarks(sc, "Chemistry");
                    int m = getValidMarks(sc, "Maths");
                    int b = getValidMarks(sc, "Biology");

                    service.addStudent(new Student(name, p, c, m, b));
                    break;

                case 2:
                    System.out.print("Enter Register Number to check result: ");
                    String regResult = sc.nextLine();
                    service.checkResult(regResult);
                    break;

                case 3:
                    service.viewAll();
                    break;

                case 4:
                    System.out.print("Enter Register Number to delete: ");
                    String regDel = sc.nextLine();
                    service.delete(regDel);
                    break;

                case 5:
                    System.out.println("Exiting... Bye!");
                    return;

                default:
                    System.out.println("⚠️ Invalid choice, please select 1-5.");
            }
        }
    }

    // Method to safely get marks input
    static int getValidMarks(Scanner sc, String subject) {
        int marks = -1;
        while (true) {
            System.out.print(subject + ": ");
            try {
                marks = sc.nextInt();
                if (marks < 0 || marks > 100) {
                    System.out.println("⚠️ Marks must be between 0-100. Try again.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Invalid input. Enter numeric marks.");
                sc.nextLine(); // consume invalid input
            }
        }
        return marks;
    }
}