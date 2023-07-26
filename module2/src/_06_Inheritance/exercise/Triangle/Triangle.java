package _06_Inheritance.exercise.Triangle;

import _06_Inheritance.practice.Shape.Shape;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
       this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public boolean isTriangle() {
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            return false;
        }
        return true;
    }

    public double getPerimeter() {
        if (isTriangle()) return side1 + side2 + side3;
        else return 0;
    }
    public double getArea() {
        if (isTriangle()) return Math.sqrt(getPerimeter()/2 * (getPerimeter()/2 - side1) * (getPerimeter()/2 - side2) * (getPerimeter()/2 - side3));
        else return 0;
    }

    @Override
    public String toString() {
        if (!isTriangle()) {
            return "It is not triangle";
        } else {
            return "Triangle {" +
                    "side1 = " + side1 +
                    ", side2 = " + side2 +
                    ", side3 = " + side3 +
                    '}' +
                    " which is subclass of " + super.toString();
        }
    }
}
