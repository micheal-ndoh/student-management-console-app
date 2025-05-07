
import java.util.Scanner;
import java.io.IOException;
import lib.*;
import static lib.Student.generateId;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        School school = new School();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Graduate Student");
            System.out.println("3. Add Course");
            System.out.println("4. Display All Students");
            System.out.println("5. Display All Courses");
            System.out.println("6. Export Student Report");
            System.out.println("7. Export All Students Report");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();

                        int age = 0;
                        while (age <= 0) {
                            System.out.print("Enter student age (must be positive): ");
                            age = scanner.nextInt();
                            scanner.nextLine();
                            if (age <= 0) {
                                System.out.println("Age must be positive. Please try again.");
                            }
                        }

                        String id = generateId();

                        Student student = new Student(id, name, age);
                        school.addStudent(student);
                        System.out.println("Student added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter graduate student name: ");
                        String gName = scanner.nextLine();

                        int gAge = 0;
                        while (gAge <= 0) {
                            System.out.print("Enter graduate student age (must be positive): ");
                            gAge = scanner.nextInt();
                            scanner.nextLine();
                            if (gAge <= 0) {
                                System.out.println("Age must be positive. Please try again.");
                            }
                        }

                        String gId = generateId();
                        
                        System.out.print("Enter thesis title: ");
                        String thesisTitle = scanner.nextLine();
                        System.out.print("Enter advisor name: ");
                        String advisorName = scanner.nextLine();

                        GraduateStudent gradStudent = new GraduateStudent(gName, gAge, gId, thesisTitle, advisorName);
                        school.addStudent(gradStudent);
                        System.out.println("Graduate student added successfully!");
                        break;

                    case 3:
                        System.out.print("Enter course name: ");
                        String courseName = scanner.nextLine();
                        System.out.print("Enter course code: ");
                        String courseCode = scanner.nextLine();
                        System.out.print("Enter course description: ");
                        String courseDesc = scanner.nextLine();

                        Course course = new Course(courseName, courseCode, courseDesc);
                        school.addCourse(course);
                        System.out.println("Course added successfully!");
                        break;

                    case 4:
                        school.displayAllStudents();
                        break;

                    case 5:
                        school.displayAllCourses();
                        break;

                    case 6:
                        System.out.print("Enter student ID to export: ");
                        String exportId = scanner.nextLine();
                        System.out.print("Enter filename to save report: ");
                        String exportFile = scanner.nextLine();

                        try {
                            school.exportStudentReport(exportId, exportFile);
                            System.out.println("Student report exported successfully!");
                            break;
                        } catch (Exception e) {
                            System.out.println("Error exporting report: " + e.getMessage());
                            break;
                        }

                    case 7:
                        System.out.print("Enter filename to save all students report: ");
                        String allExportFile = scanner.nextLine();

                        try {
                            school.exportAllStudentsReport(allExportFile);
                            System.out.println("All students report exported successfully!");
                        } catch (Exception e) {
                            System.out.println("Error exporting report: " + e.getMessage());
                        }
                        break;

                    case 8:
                        System.out.println("Thank you for using the Student Management System!");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
}
