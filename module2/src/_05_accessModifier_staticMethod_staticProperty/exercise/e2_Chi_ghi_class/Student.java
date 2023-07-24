package _05_accessModifier_staticMethod_staticProperty.exercise.e2_Chi_ghi_class;

public class Student {
    private String name;
    private static String classes;
    static {
        classes = "CO2";
    }

    public Student() {
        this.name = "John";
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setClasses(String classes) {
        Student.classes = classes;
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