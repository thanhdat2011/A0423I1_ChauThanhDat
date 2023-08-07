package _05_static.practice.p1_static_method;

public class testStaticMethod {
    public static void main(String[] args) {
        Student.change();
        Student s1 = new Student(1, "DAT");
        Student s2 = new Student(2, "Quoc");
        Student s3 = new Student(3, "Truong");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
