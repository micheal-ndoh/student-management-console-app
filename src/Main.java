import lib.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        School school = new School();

        while (true) {
            System.out.println("\n===== Student Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Graduate Student");
            System.out.println("3. View All Students");
            System.out.println("4. View All Courses");
            System.out.println("5. Export Student Report");
            System.out.println("0. Exit");
            System.out.print("Enter option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    int age;
                    while (true) {
                        System.out.print("Enter age: ");
                        age = scanner.nextInt();
                        if (age > 0) break;
                        System.out.println("Age must be positive.");
                    }
                    scanner.nextLine();

                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();

                    Student student = new Student(name, age, id);
                    school.addStudent(student);
                    System.out.println(" Student added.");
                }

                case 2 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    int age;
                    while (true) {
                        System.out.print("Enter age: ");
                        age = scanner.nextInt();
                        if (age > 0) break;
                        System.out.println("Age must be positive.");
                    }
                    scanner.nextLine();

                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();

                    List<Integer> grades = new ArrayList<>();
                    System.out.print("Enter number of grades: ");
                    int count = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        System.out.print("Grade " + (i + 1) + ": ");
                        grades.add(scanner.nextInt());
                    }
                    scanner.nextLine();

                    System.out.print("Enter thesis title: ");
                    String thesis = scanner.nextLine();

                    System.out.print("Enter advisor name: ");
                    String advisor = scanner.nextLine();

                    GraduateStudent grad = new GraduateStudent(name, age, id, grades, thesis, advisor);
                    school.addStudent(grad);
                    System.out.println("Graduate student added.");
                }

                case 3 -> {
                    for (Student s : school.getStudents()) {
                        s.displayInfo();
                        System.out.println("-----------");
                    }
                }

                case 4 -> {
                    school.displayAllCourses();
                }

                case 5 -> {
                    ReportExporter.exportStudents(school.getStudents(), "student_report.txt");
                }

                case 0 -> {
                    System.out.println("👋 Exiting...");
                    return;
                }

                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
