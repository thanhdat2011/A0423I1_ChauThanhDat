package _06_Inheritance.exercise.Circle_Cylinder;

public class Test_CC {
    public static void main(String[] args) {
        // TEST CIRCLE
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(5, "red");
        System.out.println(circle);
        System.out.printf("AREA = %.2f %n", circle.getArea());
        System.out.printf("Perimeter = %.2f %n", circle.getPerimeter());
        System.out.printf("%n");
        // TEST CYLINDER
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder.setRadius(5);
        cylinder.setColor("purple");
        cylinder.setHeight(10);
        System.out.println(cylinder);
        System.out.printf("AREA = %.2f %n", cylinder.getArea());
        System.out.printf("VOL = %.2f %n", cylinder.getVol());
        System.out.printf("Perimeter = %.2f %n", cylinder.getPerimeter());

    }
}
