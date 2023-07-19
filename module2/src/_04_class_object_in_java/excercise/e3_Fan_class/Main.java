package _04_class_object_in_java.excercise.e3_Fan_class;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan(3,10,"yellow", true);
        Fan fan2 = new Fan();
        System.out.println(fan1);
        System.out.println(fan2);
    }
}
