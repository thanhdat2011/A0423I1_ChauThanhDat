package _06_Inheritance.practice.Shape;

import _07_Abstract_Interface.Exercise.Colorable.Colorable;

public class Square extends Rectangle implements Colorable {
    public Square() {
        super(1,1);
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }
    public double getSide() {
        return getWidth();
    }
    public void setSide(double side) {              // goi toi lop cha rectangle
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "Square{" + getSide() +
                "}" +
                " which is a subclass of " + super.toString();
    }


    // this part for ex Colorable in _07_Abstract_Interface


    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
