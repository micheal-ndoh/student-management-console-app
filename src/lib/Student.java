package lib;

import java.util.UUID;

public class Student extends Person {

    private String id;
    private Grade[] grades = {};

    public record Grade(int courseId, int score) {}

    public static String generateId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public Student(String id, String name, int age) {
        super(name, age);
        this.id = generateId();
    }

    public Student(String id, String name, int age, Grade[] grades) {
        super(name, age);
        this.id = generateId();
        this.grades = grades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Grade[] getGrades() {
        return grades;
    }

    public void setGrades(Grade[] grades) {
        this.grades = grades;
    }

    public double calculateAverage() {
        if (grades.length == 0) {
            return 0;
        }
        int sum = 0;
        for (Grade grade : grades) {
            sum += grade.score();
        }
        return (double) sum / grades.length;
    }

    public double calculateGPA() {
        if (grades.length == 0) {
            return 0;
        }
        double sum = 0;
        for (Grade grade : grades) {
            int score = grade.score();
            if (score >= 90) sum += 4.0;
            else if (score >= 80) sum += 3.0;
            else if (score >= 70) sum += 2.0;
            else if (score >= 60) sum += 1.0;
        }
        return sum / grades.length;
    }

    @Override
    public String displayInfo() {
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Information:\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Name: ").append(getName()).append("\n");
        sb.append("Age: ").append(getAge()).append("\n");
        sb.append("Average Grade: ").append(calculateAverage()).append("\n");
        sb.append("GPA: ").append(calculateGPA()).append("\n");
        return sb.toString();
    }
}
