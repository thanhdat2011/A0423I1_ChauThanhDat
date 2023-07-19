package _05_accessModifier_staticMethod_staticProperty.exercise.e2_Chi_ghi_class;

public class Student {
    private String name;
    private String classes;

    public Student(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }
    public Student() {
        this.name = "John";
        this.classes = "CO2";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
    // change modifier of setName and setClasses => ERROR