package lib;

public class GraduateStudent extends Student {
    private String thesisTitle;
    private String advisorName;

    public GraduateStudent(String name, int age, String id, String thesisTitle, String advisorName) {
        super(id, name, age);
        this.thesisTitle = thesisTitle;
        this.advisorName = advisorName;
    }

    public String getThesisTitle() { return thesisTitle; }
    public void setThesisTitle(String thesisTitle) { this.thesisTitle = thesisTitle; }

    public String getAdvisorName() { return advisorName; }
    public void setAdvisorName(String advisorName) { this.advisorName = advisorName; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Thesis Title: ").append(thesisTitle).append("\n");
        sb.append("Advisor: ").append(advisorName).append("\n");
        return sb.toString();
    }
}
