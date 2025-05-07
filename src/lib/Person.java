package lib;
public abstract class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive");
        }
        this.name = name;
        this.age = age;
    }
    
    public  Person build() {
        return new Person("nkwenti", 5) {
            @Override
            public String displayInfo() {
                // TODO Auto-generated method stub
                return "";
            }
        };
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { 
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive");
        }
        this.age = age; 
    }
    
    
    public abstract String displayInfo();
} 