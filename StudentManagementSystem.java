package MiniProject3;

import java.util.*;

public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    static void login() {
        String user = "admin";
        String pass = "1234";

        System.out.print("Enter Username: ");
        String u = sc.next();
        System.out.print("Enter Password: ");
        String p = sc.next();

        if (!u.equals(user) || !p.equals(pass)) {
            System.out.println("❌ Invalid Login Credentials");
            System.exit(0);
        }
        System.out.println("✅ Login Successful\n");
    }

    static void addStudent() throws Exception {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        for (Student s : students) {
            if (s.eno == eno)
                throw new DuplicateEnoException("Eno already exists!");
        }

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Branch: ");
        String branch = sc.next();
        if (branch.isEmpty())
            throw new InvalidInputException("Branch cannot be empty");

        System.out.print("Enter Semester: ");
        int sem = sc.nextInt();
        if (sem <= 0)
            throw new InvalidInputException("Semester must be positive");

        System.out.print("Enter Percentage: ");
        double per = sc.nextDouble();
        if (per <= 0)
            throw new InvalidPercentageException("Percentage must be positive");

        students.add(new Student(eno, name, branch, sem, per));
        System.out.println("✅ Student Added Successfully");
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        for (Student s : students)
            s.display();
    }

    static void searchStudent() {
        System.out.print("Enter Eno to search: ");
        int eno = sc.nextInt();

        for (Student s : students) {
            if (s.eno == eno) {
                s.display();
                return;
            }
        }
        System.out.println("❌ Student not found");
    }

    static void updateBranch() {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        for (Student s : students) {
            if (s.eno == eno) {
                System.out.print("Enter New Branch: ");
                s.branch = sc.next();
                System.out.println("✅ Branch Updated");
                return;
            }
        }
        System.out.println("❌ Student not found");
    }

    static void deleteStudent() {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().eno == eno) {
                it.remove();
                System.out.println("✅ Student Deleted");
                return;
            }
        }
        System.out.println("❌ Student not found");
    }

    static void sortStudents() {
        students.sort(Comparator.comparingInt(s -> s.eno));
        System.out.println("✅ Students Sorted by Eno");
    }

    public static void main(String[] args) {
        login();

        while (true) {
            System.out.println("""
                1. Add Students
                2. Display All Students
                3. Search Students by Eno
                4. Update Students Branch
                5. Delete Students by Eno
                6. Display Sorted Students
                7. Exit
                """);

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            try {
                switch (ch) {
                    case 1 -> addStudent();
                    case 2 -> displayStudents();
                    case 3 -> searchStudent();
                    case 4 -> updateBranch();
                    case 5 -> deleteStudent();
                    case 6 -> sortStudents();
                    case 7 -> System.exit(0);
                    default -> System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        }
    }
}
