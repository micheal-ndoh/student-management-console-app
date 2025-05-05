package lib;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    protected String studentId;
    protected List<Integer> grades;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }

    public Student(String name, int age, String studentId, List<Integer> grades) {
        super(name, age);
        this.studentId = studentId;
        this.grades = grades;
    }

    public String getStudentId() { return studentId; }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public List<Integer> getGrades() { return grades; }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int grade : grades) sum += grade;
        return (double) sum / grades.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(studentId).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Age: ").append(age).append("\n");
        sb.append("Grades: ").append(grades.toString()).append("\n");
        sb.append("GPA: ").append(String.format("%.2f", calculateGPA())).append("\n");
        return sb.toString();
    }

    @Override
    public void displayInfo() {
        System.out.println(this);
    }
}
