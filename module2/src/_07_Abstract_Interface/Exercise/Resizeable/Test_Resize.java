package _07_Abstract_Interface.Exercise.Resizeable;

import _06_Inheritance.practice.Shape.Circle;
import _06_Inheritance.practice.Shape.Rectangle;
import _06_Inheritance.practice.Shape.Shape;

public class Test_Resize {
    public static void main(String[] args) {

//        Circle circle = new Circle(5);
//        Rectangle rectangle = new Rectangle(5, 10);
//        System.out.println(circle);
//        System.out.println(rectangle);
//        circle.resize(0.2);
//        rectangle.resize(0.5);
//        System.out.println(circle);
//        System.out.println(rectangle);

        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(5,10);
        for (Shape e : shapes) {
            if (e instanceof Circle) {
                System.out.println("------Cirle------");
                System.out.printf("Before resize = %.2f %n", ((Circle) e).getArea());
                ((Circle) e).resize(Math.random()*100);
                System.out.printf("After resize = %.2f %n", ((Circle) e).getArea());
            }
            if (e instanceof Rectangle) {
                System.out.println("------Rectangle------");
                System.out.printf("Before resize = %.2f %n", ((Rectangle) e).getArea());
                ((Rectangle) e).resize(Math.random()*100);
                System.out.printf("After resize = %.2f %n", ((Rectangle) e).getArea());
            }
        }
    }
}
