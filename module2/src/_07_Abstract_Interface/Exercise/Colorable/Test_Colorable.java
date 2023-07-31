package _07_Abstract_Interface.Exercise.Colorable;

import _06_Inheritance.practice.Shape.Circle;
import _06_Inheritance.practice.Shape.Rectangle;
import _06_Inheritance.practice.Shape.Shape;
import _06_Inheritance.practice.Shape.Square;

public class Test_Colorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Square();
        shapes[2] = new Rectangle();

        for (Shape e : shapes) {
            System.out.println(e);
            if (e instanceof Colorable) {
               ((Colorable) e).howToColor();
            }
            System.out.println("--------------");
        }
    }
}
