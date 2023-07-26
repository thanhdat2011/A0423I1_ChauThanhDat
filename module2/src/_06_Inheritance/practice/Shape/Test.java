package _06_Inheritance.practice.Shape;

public class Test {
    public static void main(String[] args) {
        // TEST SHAPE
        Shape shape = new Shape();
        System.out.println(shape);
        shape = new Shape("blue", false);
        System.out.println(shape);
        System.out.println();
        // TEST CIRCLE
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle("red", true, 5);
        System.out.println(circle);
        System.out.println(circle.getArea());
        System.out.println();
        // TEST RECTANGLE
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);
        rectangle = new Rectangle("yellow", true, 5 , 10 );
        System.out.println(rectangle);
        System.out.printf("Perimeter : %.2f %n", rectangle.getPerimeter());
        System.out.printf("Area : %.2f", rectangle.getArea());
        System.out.printf("%n %n");
        // TEST SQUARE
        Square square = new Square();
        System.out.println(square);
        square = new Square(5);
        square.setSide(10);
        System.out.println(square);
        square.setLength(2.666);
        System.out.println(square);
        System.out.printf("Area : %.2f", square.getArea());
    }
}
