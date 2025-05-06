package lib;

import java.util.List;

public class GraduateStudent extends Student {
    private String thesisTitle;
    private String advisorName;

    public GraduateStudent(String name, int age, String studentId,
                           List<Integer> grades, String thesisTitle, String advisorName) {
        super(name, age, grades);
        this.thesisTitle = thesisTitle;
        this.advisorName = advisorName;
    }

    public String getThesisTitle() { return thesisTitle; }
    public String getAdvisorName() { return advisorName; }

    @Override
    public void displayInfo() {
        System.out.println(super.toString());
        System.out.println("Thesis: " + thesisTitle);
        System.out.println("Advisor: " + advisorName);
    }
}
