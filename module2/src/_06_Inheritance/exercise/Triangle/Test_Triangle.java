package _06_Inheritance.exercise.Triangle;

public class Test_Triangle {
    public static void main(String[] args) {
        // IS TRIANGLE
        Triangle triangle1 = new Triangle();
        System.out.println(triangle1);
        triangle1 = new Triangle(1,2,3);
        System.out.println(triangle1);
        System.out.printf("Perimeter = %.2f %n", triangle1.getPerimeter());
        System.out.printf("Area = %.2f %n", triangle1.getArea());
        System.out.printf("%n");
        // IS NOT TRIANGLE
        Triangle triangle2 = new Triangle(2,2,10);
        System.out.println(triangle2);
        System.out.printf("Perimeter = %.2f %n", triangle1.getPerimeter());
        System.out.printf("Area = %.2f %n", triangle1.getArea());
    }
}
