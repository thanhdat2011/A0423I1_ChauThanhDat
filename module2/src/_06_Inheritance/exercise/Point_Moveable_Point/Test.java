package _06_Inheritance.exercise.Point_Moveable_Point;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        // TEST POINT
        Point point = new Point();
        System.out.println(point);
        point = new Point(15,9);
        System.out.println(point);
        System.out.println(Arrays.toString(point.getXY()));
        System.out.printf("%n");
        // TEST MOVEABLE POINT
        Moveable_Point moveablePoint = new Moveable_Point();
        System.out.println(moveablePoint);
        moveablePoint = new Moveable_Point(20,11,15,9);
        System.out.println(moveablePoint);
        System.out.println("MOVE");
        moveablePoint.move();
        System.out.println(moveablePoint);
        moveablePoint.setSpeed(10,10);
        System.out.println(moveablePoint);
        System.out.println("MOVE");
        moveablePoint.move();
        System.out.println(moveablePoint);
    }
}
