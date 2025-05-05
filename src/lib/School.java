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

    public void displayAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses added.");
            return;
        }
        for (Course course : courses) {
            System.out.println(course);
        }
    }
}
