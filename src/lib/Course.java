package lib;

public class Course {

    private String name;
    private String code;
    private String description;

    public Course(String name, String code, String description) {
        this.name = name;
        this.code = code;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course Information:\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Code: ").append(code).append("\n");
        sb.append("Description: ").append(description).append("\n");
        return sb.toString();
    }
}
