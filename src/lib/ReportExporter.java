package lib;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReportExporter {

    public static void exportStudents(List<Student> students, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.println(student.toString());
                writer.println("--------------------------");
            }
            System.out.println("Report exported to " + filename);
        } catch (IOException e) {
            System.out.println("Failed to export report: " + e.getMessage());
        }
    }
}
