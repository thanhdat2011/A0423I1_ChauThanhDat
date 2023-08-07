package _05_static.exercise.e2_Chi_ghi_class;

public class Test_Student {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        Student.setClasses("AOAOAO");
        student2.setName("DAT");
        System.out.println(student1);
        System.out.println(student2);
    }
}
