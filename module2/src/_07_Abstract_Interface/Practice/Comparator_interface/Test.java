package _07_Abstract_Interface.Practice.Comparator_interface;

import _06_Inheritance.exercise.Circle_Cylinder.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Circle[] circles = new Circle[4];
        circles[0] = new Circle();
        circles[1] = new Circle(10, "red");
        circles[2] = new Circle(1, "blue");
        circles[3] = new Circle(2, "white");
        System.out.println("Before sort");
        for (Circle e : circles) {
            System.out.println(e);
        }

        Comparator<Circle> circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("After sort");
        for (Circle e : circles) {
            System.out.println(e);
        }
    }
}
