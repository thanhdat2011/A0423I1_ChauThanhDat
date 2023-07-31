package _07_Abstract_Interface.Practice.Comparable_interface;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Comparable_Circle[] comparableCircles = new Comparable_Circle[4];
        comparableCircles[0] = new Comparable_Circle(10, "red");
        comparableCircles[1] = new Comparable_Circle(1, "blue");
        comparableCircles[2] = new Comparable_Circle(5, "yellow");
        comparableCircles[3] = new Comparable_Circle(5, "purple");
        System.out.println("Before sort");
        for (Comparable_Circle e : comparableCircles) {
            System.out.println(e);
        }

        Arrays.sort(comparableCircles);

        System.out.println("After sort");
        for (Comparable_Circle e : comparableCircles) {
            System.out.println(e);
        }

    }
}
