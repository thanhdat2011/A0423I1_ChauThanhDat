package _07_Abstract_Interface.Practice.Comparable_interface;

import _06_Inheritance.exercise.Circle_Cylinder.Circle;

public class Comparable_Circle extends Circle implements Comparable<Comparable_Circle> {
    public Comparable_Circle() {
    }

    public Comparable_Circle(double radius, String color) {
        super(radius, color);
    }

    @Override
    public int compareTo(Comparable_Circle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 0;
    }
}
