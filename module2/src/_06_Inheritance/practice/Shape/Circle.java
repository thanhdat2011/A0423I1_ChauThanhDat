package _06_Inheritance.practice.Shape;

import _07_Abstract_Interface.Exercise.Resizeable.IResizeable;

public class Circle extends Shape implements IResizeable {
    private double radius = 1.0;
    public Circle() {
    }
    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius,2);
    }
    public double getParimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}' +
                ", which is subclass of " + super.toString();
    }


    // This part for ex Resizeable in _07_Abstract_Interface

    @Override
    public void resize(double percent) {
        radius += radius*percent;
    }
}
