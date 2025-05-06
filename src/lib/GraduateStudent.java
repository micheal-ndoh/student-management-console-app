package lib;

import java.util.List;

public class GraduateStudent extends Student {

    private String Project;
    private String advisorName;

    public GraduateStudent(String name, int age, List<Integer> grades, String Project, String advisorName) {
        super(name, age, grades);
        this.Project = Project;
        this.advisorName = advisorName;
    }

    public String getProject() {
        return Project;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    @Override
    public void displayInfo() {
        System.out.println(super.toString());
        System.out.println("Project: " + Project);
        System.out.println("Advisor: " + advisorName);
    }

    public void setProject(String Project) {
        this.Project = Project;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }
}
