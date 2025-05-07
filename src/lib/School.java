package lib;

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void displayAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses added.");
            return;
        }
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public void exportStudentReport(String id, String filename) throws Exception {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                ReportExporter.exportStudents(List.of(student), filename);
                return;
            }
        }
        throw new Exception("Student with ID " + id + " not found.");
    }

    public void exportAllStudentsReport(String filename) throws Exception {
        if (students.isEmpty()) {
            throw new Exception("No students to export.");
        }
        ReportExporter.exportStudents(students, filename);
    }
}
