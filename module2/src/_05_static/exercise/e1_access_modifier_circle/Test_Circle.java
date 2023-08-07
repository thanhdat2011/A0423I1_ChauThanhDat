package _05_static.exercise.e1_access_modifier_circle;

public class Test_Circle {
    public static void main(String[] args) {
        Circle c1 = new Circle(10);
        Circle c2 = new Circle();
        System.out.println(c1.getRadius());
        System.out.println(c1.getArea());
        System.out.println(c2.getRadius());
        System.out.println(c2.getArea());
    }
}
